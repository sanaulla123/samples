<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:th="http://www.thymeleaf.org">
    <xsl:output method="html" />
    <xsl:template match="detail">
        <div class="row">
            <div class="col">
                <h3>Details</h3>
                <form class="form-view">
                    <div class="form-group row">
                        <label for="" class="col-12 col-sm-4 col-lg-3 col-xl-2 col-form-label">Brand</label>
                        <div class="col-12 col-sm-8 col-lg-3 col-xl-4">
                            <span class="label-value"> <xsl:value-of select="product/brand"  /> </span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-12 col-sm-4 col-lg-3 col-xl-2 col-form-label">Product</label>
                        <div class="col-12 col-sm-8 col-lg-3 col-xl-4">
                            <span class="label-value"><xsl:value-of select="product/detail"  /> </span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-12 col-sm-4 col-lg-3 col-xl-2 col-form-label">Manufacturer</label>
                        <div class="col-12 col-sm-8 col-lg-3 col-xl-4">
                            <span class="label-value"><xsl:value-of select="manufacturer/name"  /> </span>
                        </div>
                        <label for="" class="col-12 col-sm-4 col-lg-3 col-xl-2 col-form-label">Manufactured In</label>
                        <div class="col-12 col-sm-8 col-lg-3 col-xl-4">
                            <span class="label-value">
                                <xsl:value-of select="manufacturer/country/name"  />
                            </span>
                        </div>
                    </div>
                </form><!-- End of .form-view -->
                <h3>Models</h3>
                <div class="table-responsive">
                    <table class="table table-hover" border="0" cellpadding="0" cellspacing="0">
                        <thead v-once="">
                            <tr>
                                <th>Index</th>
                                <th width="30%">Model Number</th>
                                <th width="70%">Notes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="product/models/model">
                                <tr>
                                    <td><xsl:value-of select="position()"/> </td>
                                    <td data-label="Model Number"><xsl:value-of select="model-no" />  </td>
                                    <td data-label="Notes"><xsl:value-of select="model-notes" />  </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </div><!-- End of .col -->
        </div><!-- End of .row -->
    </xsl:template>
    <xsl:template match="/">
    <html lang="en">
        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <title>XML to HTML</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
                  rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
                  crossorigin="anonymous" />
        </head>
        <body>
            <div class="container">
             <xsl:apply-templates />
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                    crossorigin="anonymous"></script>
        </body>
    </html>
    </xsl:template>
</xsl:stylesheet>