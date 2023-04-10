package org.example;

import net.sf.saxon.s9api.*;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class AppParamDemo {
    public static void main(String[] args) throws SaxonApiException {
        Processor processor = new Processor(false);

        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        InputStream xsltStream = ClassLoader.getSystemResourceAsStream("sample-xslt3.xsl");
        xsltCompiler.setParameter(new QName("message"), new XdmAtomicValue("Good Morning"));
        XsltExecutable xsltExecutable = xsltCompiler.compile(new StreamSource(xsltStream));
        Xslt30Transformer xsltTransformer30 = xsltExecutable.load30();


        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        Serializer byteArrayOutput = xsltTransformer30.newSerializer(arrayOutputStream);
        byteArrayOutput.setOutputProperty(Serializer.Property.INDENT, "yes");
        byteArrayOutput.setOutputProperty(Serializer.Property.METHOD, "html");
        byteArrayOutput.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");

        StreamSource streamSource = new StreamSource(ClassLoader.getSystemResourceAsStream("sample-xml3.xml"));
        xsltTransformer30.transform(streamSource, byteArrayOutput);
        System.out.println(arrayOutputStream);
    }
}
