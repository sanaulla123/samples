package info.sanaulla;

import net.sf.saxon.s9api.*;
import org.apache.fop.apps.*;

import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SaxonApiException, FileNotFoundException {
        Processor processor = new Processor(false);

        XsltCompiler xsltCompiler = processor.newXsltCompiler();
        InputStream xsltStream = ClassLoader.getSystemResourceAsStream("sample-fo.xsl");
        XsltExecutable xsltExecutable = xsltCompiler.compile(new StreamSource(xsltStream));
        Xslt30Transformer xsltTransformer30 = xsltExecutable.load30();


        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        Serializer byteArrayOutput = xsltTransformer30.newSerializer(arrayOutputStream);
        byteArrayOutput.setOutputProperty(Serializer.Property.INDENT, "yes");
        byteArrayOutput.setOutputProperty(Serializer.Property.METHOD, "html");
        byteArrayOutput.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");

        StreamSource streamSource = new StreamSource(ClassLoader.getSystemResourceAsStream("sample-xml2.xml"));
        FopFactoryBuilder fopFactoryBuilder = new FopFactoryBuilder(new File(".").toURI());
        FopFactory fopFactory = fopFactoryBuilder.build();
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        try(ByteArrayOutputStream pdfoutStream = new ByteArrayOutputStream();
            FileOutputStream outputStream = new FileOutputStream("sample-fop2.pdf")) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, pdfoutStream);
            System.out.println("FOP created");
            SAXDestination saxDestination = new SAXDestination(fop.getDefaultHandler());
            xsltTransformer30.transform(streamSource, saxDestination);

            outputStream.write(pdfoutStream.toByteArray());

            System.out.println("File Created");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FOPException e) {
            throw new RuntimeException(e);
        }
    }
}
