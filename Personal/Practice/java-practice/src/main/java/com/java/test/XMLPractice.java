package com.java.test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

public class XMLPractice {
    private static final String FILENAME = "C:\\Users\\subbanarasa.puttana\\Documents\\Personal\\Practice\\java-practice\\src\\main\\resources\\mx-msg.xml";


    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try (InputStream is = new FileInputStream(FILENAME)) {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(is);

            NodeList listOfStaff = doc.getElementsByTagName("BICFI");
            for (int i = 0; i < listOfStaff.getLength(); i++) {
               Node node =  listOfStaff.item(i);
                System.out.println( node.getTextContent());
                String bic = node.getTextContent();
                char[] chars = bic.toCharArray();
                chars[7] = '0';
                node.setTextContent(String.valueOf(chars));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // pretty print
          //  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           // transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            StringWriter stringWriter = new StringWriter();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(stringWriter);

            transformer.transform(source, result);
            System.out.println(stringWriter);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
