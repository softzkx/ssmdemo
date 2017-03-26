package com.jeff.util;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by he on 2016/8/16.
 */
public class XmlUtil {

    public static Object xmlToObject(Class<?> targetClz, String soureXml) {
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader2 = new StringReader(soureXml);
            SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(reader2));
            object = unmarshaller.unmarshal(source);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            return object;
        }
    }

    public static Object xmlToObject(Class<?> targetClz, InputStream input) {
        Object object = null;
        Source source = null;
        XMLReader xmlReader = null;
        String xmlStr = null;
        try {
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[4096];
            for (int n; (n = input.read(b)) != -1;) {
                out.append(new String(b, 0, n));
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            xmlStr = out.toString();
            System.out.println(xmlStr);
            StringReader reader2 = new StringReader(xmlStr);
            SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            xmlReader = sax.newSAXParser().getXMLReader();
            source = new SAXSource(xmlReader, new InputSource(reader2));
            object = unmarshaller.unmarshal(source);
        } catch (Exception e) {
            System.out.println(xmlStr);
            e.printStackTrace();
        } finally {
            return object;
        }
    }

    public static String objectToXml(Object sourceTarget) {
        String xml = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(sourceTarget.getClass());
            Marshaller m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE); //是否格式化XML，格式化有性能损耗
            StringWriter sw = new StringWriter();
            m.marshal(sourceTarget, sw);
            xml = sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return xml;
        }
    }

}
