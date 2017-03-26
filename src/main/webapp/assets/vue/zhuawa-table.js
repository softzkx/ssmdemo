(function (Vue, $) {
    window.TableCtx = function (ops) {
        var ctx = {
            url: '',
            pageSize: 10,
            columns: [],
            actions: [],
            params: {},
            rows: [],
            totalPage: 0,
            currentPage: 1,
            totalSize: 0,
            startRow: 0,
            endRow: 0,
            loadData: null,
            /**展示**/
            tableClz: 'table table-bordered table-responsive table-hover table-striped',
            tableStyle: 'margin-bottom:10px;',
            thClz: '',
            thStyle: 'font-family: "Microsoft YaHei"; cursor: pointer;',
            tdClz: '',
            tdStyle: '',
            actionTdClz: 'text-center',
            actionTdStyle: '',
            actionBtnClz: 'btn btn-sm btn-default',
            actionBtnStyle: 'margin: 2px',
            actionIconClz: '',
            actionIconStyle: '',
            sortUpIconClz: '',
            sortDownIconStyle: '',
            sortIconStyle: ''
        };
        $.extend(ctx, ops);
        return ctx;
    }

    Vue.component('vue-table', {
        template: '<hr style="margin-bottom: 15px;margin-top: 15px;"/>'
        + '<table class="{{ctx.tableClz}}" style="{{ctx.tableStyle}}" >'
        + '<thead><tr>'
        + '<template v-for="column in ctx.columns">'
        + '<th v-if="column.sortType==undefined||column.sortType==null" class="{{column.thClz||ctx.thClz}}" style="{{column.thStyle||ctx.thStyle}}" >{{column.title}}</th>'
        + '<th v-else class="{{column.thClz||ctx.thClz}}" style="{{column.thStyle||ctx.thStyle}}" title="点击可排序" @click="doSort(column)" >'
        + '{{column.title}}'
        + '<span class="{{column.sortType?ctx.sortUpIconClz:ctx.sortDownIconClz}}" style="{{ctx.sortIconStyle}}"></span>'
        + '</th>'
        + '</template>'
        + '<th v-if="ctx.actions" class="{{column.thClz||ctx.thClz}}" style="{{column.thStyle||ctx.thStyle}}" >操作</th>'
        + '</tr></thead>'
        + '<tbody>'
        + '<template v-for="row in ctx.rows">'
        + '<tr>'
        + '<template v-for="column in ctx.columns">'
        + '<td class="{{column.tdClz||tdClz}}" style="{{tdStyle}}" >{{row[column.field]}}</td>'
        + '</template>'
        + '<td v-if="ctx.actions != null" class="{{ctx.actionTdClz}}" style="{{ctx.actionTdStyle}}" >'
        + '<template  v-for="action in ctx.actions">'
        + '<button class="{{action.btnClz||ctx.actionBtnClz}}" title="{{action.title||defaultActionTitle}}" style="{{action.btnStyle||ctx.actionBtnStyle}}" @click="action.handler(row,$root)" >'
        + '<span class="{{action.iconClz||ctx.actionIconClz}}" style="{{action.iconStyle||ctx.actionIconStyle}}" ></span>'
        + '</button>'
        + '</template>'
        + '</td>'
        + '</tr>'
        + '</template>'
        + '</tbody>'
        + '</table>'
        + '<div class="row">'
        + '<div class="col-md-4">'
        + '<h5 class="pull-left" v-if="ctx.totalSize>0">本页展示第{{ctx.startRow+1}}到第{{ctx.endRow}}条记录，共{{ctx.totalSize}}条</h5>'
        + ' <h5 class="pull-left" v-else >没有找到相关记录</h5>'
        + '</div>'
        + '<div class="col-md-8">'
        + '<ul class="pagination pull-right">'
        + '<li v-if="ctx.currentPage>1" title="上一页" @click="turnTo(ctx.currentPage-1)"><a href="#"><span>Previous</span></a></li>'
        + '<li v-for="page in pages" title="{{page.title}}" class="{{page.class}}" @click="turnTo(page.value)"><a href="#"><span>{{page.value}}</span></a></li>'
        + '<li v-if="ctx.currentPage!=ctx.totalPage" title="下一页" @click="turnTo(ctx.currentPage+1)" ><a href="#" ><span>Next</span></a></li>'
        + '</ul>'
        + '</div>'
        + '</div>'
        + '<hr style="margin-bottom: 10px;margin-top: 0px;"/>'
        ,
        data: function () {
            return {
                defaultActionTitle: '未知操作'
            };
        },
        props: {
            ctx: {
                type: Object,
                required: true,
                twoWay: true
            }
        },
        computed: {
            'pages': function () {
                var totalPage = this.ctx.totalPage;
                var currentPage = this.ctx.currentPage;
                var i = 1;
                var pages = [];
                if (totalPage < 0) {
                    return pages;
                }
                if (totalPage < 5) {
                    for (i = 1; i <= totalPage; i++) {
                        if (i == currentPage) {
                            pages.push({value: i, title: '当前页', class: "active disabled"});
                        } else {
                            pages.push({value: i, title: '转到第' + i + '页', class: ""});
                        }
                    }
                } else {
                    if (currentPage - 1 > 2 && totalPage - currentPage > 2) {
                        pages.push({value: 1, title: '转到第1页', class: ""});
                        pages.push({value: "...", title: '', class: "disabled"});
                        pages.push({value: currentPage - 1, title: '转到第' + (currentPage - 1) + '页', class: ""});
                        pages.push({value: currentPage, title: '当前页', class: "active"});
                        pages.push({value: currentPage + 1, title: '转到第' + (currentPage + 1) + '页', class: ""});
                        pages.push({value: "...", title: '', class: "disabled"});
                        pages.push({value: totalPage, title: '转到最后一页', class: ""});
                    }
                    else if (currentPage - 1 > 2 && totalPage - currentPage <= 2) {
                        pages.push({value: 1, title: '转到第1页', class: ""});
                        pages.push({value: "...", title: '', class: "disabled"});
                        for (i = totalPage - 2; i <= totalPage; i++) {
                            if (i == currentPage) {
                                pages.push({value: i, title: '当前页', class: "active"});
                            } else {
                                pages.push({value: i, title: '转到第' + i + '页', class: ""});
                            }
                        }
                    } else {
                        for (i = 1; i <= 3; i++) {
                            if (i == currentPage) {
                                pages.push({value: i, title: '当前页', class: "active"});
                            } else {
                                pages.push({value: i, title: '转到第' + i + '页', class: ""});
                            }
                        }
                        pages.push({value: "...", title: '', class: "disabled"});
                        pages.push({value: totalPage, title: '转到最后一页', class: ""});
                    }
                }
                return pages;
            }
        },
        watch: {
            'ctx.pageSize': function (val, oldVal) {
                this.loadData();
            }
        },
        methods: {
            'turnTo': function (page) {
                page = parseInt(page);
                if (isNaN(page)) {
                    return;
                }
                this.ctx.currentPage = page;
                this.loadData();
            },
            'loadData': function () {
                var ajaxData = {
                    'pageSize': this.ctx.pageSize,
                    'pageNum': this.ctx.currentPage
                };
                for (var key in this.ctx.params) {
                    var val = this.ctx.params[key];
                    if (val != null && typeof val == 'string' && val.trim() != '') {
                        ajaxData[key] = val;
                    }
                }
                var temp = this;
                $.ajax({
                    type: "post",
                    url: temp.ctx.url,
                    cache: "false",
                    data: ajaxData,
                    dataType: "json",
                    success: function (result) {
                        if (!result.success) {
                            alert('获取数据失败');
                        } else {
                            $.extend(temp.ctx, result.page);
                        }
                    }
                });
            },
            'sort': function (column) {
               
            }
        },
        events: {},
        ready: function () {
            this.ctx.loadData = this.loadData;
            this.loadData();//获取数据
        }
    });
})(window.Vue, window.jQuery);