<?xml version="1.1" encoding="utf-8"?>
<xsl:stylesheet xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <xsl:template match="detail">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="my_page" margin="0.5in"
                                       page-height="11.7in" page-width="8.3in">

                    <fo:region-body  region-name="xsl-region-body" margin-bottom="0.5in" margin-top="0.50in"/>
                    <fo:region-before region-name="xsl-region-before" />
                    <fo:region-after region-name="xsl-region-after" />
                </fo:simple-page-master>
                <fo:simple-page-master master-name="my_page_no_footer_a5" margin="0.5in"
                    page-height="8.3in" page-width="5.8in">

                    <fo:region-body  region-name="xsl-region-body"/>
                </fo:simple-page-master>
                <fo:simple-page-master master-name="my_page_landscape" margin="0.5in"
                                       page-height="8.3in" page-width="11.7in">

                    <fo:region-body  region-name="xsl-region-body"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="my_page">

                <fo:static-content flow-name="xsl-region-before">
                    <fo:block color="blue">This is Header</fo:block>
                </fo:static-content>
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block text-align="center" color="red" font-size="small" font-style="italic">This is footer</fo:block>
                    <fo:block text-align="right" font-style="italic">
                        <fo:page-number />
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="15pt" font-weight="bold" padding-bottom="5mm">Product Information</fo:block>
                    <fo:block>
                        <fo:inline font-weight="bold" padding-end="10mm">Product</fo:inline>
                        <fo:inline><xsl:value-of select="product/detail"/></fo:inline>
                    </fo:block>
                    <fo:block>
                        <fo:inline font-weight="bold" padding-end="10mm">Brand</fo:inline>
                        <fo:inline><xsl:value-of select="product/brand"/></fo:inline>
                    </fo:block>
                    <fo:block font-size="15pt" font-weight="bold" padding-top="5mm"
                              padding-bottom="5mm">Models</fo:block>
                    <fo:table>
                        <fo:table-body border="solid 1pt">
                            <fo:table-row font-weight="bold">
                                <fo:table-cell>
                                    <fo:block>Model No</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Notes</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="my_page_no_footer_a5">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        This is a page without header and footer in A5
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="my_page_landscape">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        This is a landscape page
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="/">
        <xsl:apply-templates></xsl:apply-templates>
    </xsl:template>
</xsl:stylesheet>