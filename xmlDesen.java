import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class xmlDesen {

    public static void main(String[] args){

        try {
            File inputFile = new File("IRAS_Export.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("project-information");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :"
                        + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Title f: "
                            + eElement
                            .getElementsByTagName("Administrative_Details_Project_Short_Title")
                            .item(0)
                            .getTextContent());
                    System.out.println("IRAS Code : "
                            + eElement
                            .getElementsByTagName("Administrative_Details_Project_Submission_Code")
                            .item(0)
                            .getTextContent());
                    System.out.println("Type : "
                            + eElement
                            .getElementsByTagName("Administrative_Details_Project_Type")
                            .item(0)
                            .getTextContent());



                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
