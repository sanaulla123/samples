package org.example;

import net.sf.saxon.s9api.*;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SaxonApiException, FileNotFoundException {
        Processor processor = new Processor(false);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("sample-html.html"));
        Serializer output = processor.newSerializer(fileOutputStream);
        output.setOutputProperty(Serializer.Property.INDENT, "yes");
        output.setOutputProperty(Serializer.Property.METHOD, "html");
        output.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");



        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        InputStream xsltStream = ClassLoader.getSystemResourceAsStream("sample-xslt2.xsl");
        XsltExecutable xsltExecutable = xsltCompiler.compile(new StreamSource(xsltStream));
        Xslt30Transformer xsltTransformer30 = xsltExecutable.load30();


        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        Serializer byteArrayOutput = xsltTransformer30.newSerializer(arrayOutputStream);
        byteArrayOutput.setOutputProperty(Serializer.Property.INDENT, "yes");
        byteArrayOutput.setOutputProperty(Serializer.Property.METHOD, "html");
        byteArrayOutput.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");

        StreamSource streamSource = new StreamSource(ClassLoader.getSystemResourceAsStream("sample-xml2.xml"));
        xsltTransformer30.transform(streamSource, byteArrayOutput);
        System.out.println(arrayOutputStream.toString());

        //XLST 2
        /*XsltTransformer xsltTransformer = xsltExecutable.load();
        xsltTransformer.setSource(streamSource);
        xsltTransformer.setDestination(byteArrayOutput);
        xsltTransformer.transform();*/


    }
}
