package Parsers.dom;

import Parsers.model.Country;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DomParserUSA
{
    public List<Country> parse(Document document) throws FileNotFoundException, XMLStreamException
    {
        NodeList nodeList = document.getElementsByTagName("Country");
        List<Country> countries = new ArrayList<Country>();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            countries.add(getEmployee(nodeList.item(i)));
        }
        return countries;
    }

    private static Country getEmployee(Node node)
    {
        Country country = new Country();
        Element element = (Element) node;
        country.setCode(getTagValue("Code", element));
        country.setName(getTagValue("Name", element));
        country.setDescription(getTagValue("Description", element));
        return country;
    }

    private static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}