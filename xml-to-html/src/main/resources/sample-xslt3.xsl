<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs='http://www.w3.org/2001/XMLSchema'>
    <xsl:output method="html"/>
    <xsl:param name="message" as="xs:string">Hello</xsl:param>
    <xsl:template match="/person">
        <html>
            <body>
                <h3>
                    <xsl:value-of select="$message" />, <xsl:value-of select="name" /> from <xsl:value-of select="country" />
                </h3>
                <h4>Programming Languages</h4>
                <ul>
                    <xsl:for-each select="programming-languages/programming-language">
                        <li><xsl:value-of select="." /> </li>
                    </xsl:for-each>

                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>