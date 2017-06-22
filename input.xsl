<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:st3="http://nure.ua/kramarenko/SummaryTask3/entity" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:xslFormatting="urn:xslFormatting">
<xsl:output method="html" indent="no"/>
<xsl:template match="/">
  <html>
  <body>
  <h2>WarPlanes</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
       <th rowspan="2">Model</th>
       <th rowspan="2">Origin</th>
       <th colspan="4">Charactiristics:</th>
       <th colspan="3">Parameters:</th>
       <th rowspan="2">Price</th>
      </tr>
       <tr bgcolor="#9acd32">
       <th>Type</th>
       <th>Places</th>
       <th>Ammo</th>
       <th>Radar</th>
       <th>Length</th>
       <th>Width</th>
       <th>Height</th>
     </tr >
      <xsl:for-each select="st3:Planes/Plane">
      <tr>
        <td rowspan="2" align="center"><xsl:value-of select="model"/></td>
        <td rowspan="2" align="center"><xsl:value-of select="origin"/></td>
        <td rowspan="2"><xsl:value-of select="chars/type"/></td>
        <td rowspan="2" align="center"><xsl:value-of select="chars/places"/></td>
        <td align="center"><xsl:value-of select="chars/ammo"/></td>
        <td rowspan="2" align="center"><xsl:value-of select="chars/radar"/></td>
        <td rowspan="2"><xsl:value-of select="parameters/length"/>
            <xsl:value-of select="parameters/@unit"/></td>
        <td rowspan="2"><xsl:value-of select="parameters/width"/>
            <xsl:value-of select="parameters/@unit"/></td>
        <td rowspan="2"><xsl:value-of select="parameters/height"/>
            <xsl:value-of select="parameters/@unit"/></td>
        <td rowspan="2"><xsl:value-of select="price"/> <xsl:value-of select="price/@unit"/></td>
      </tr>
      <tr>
      <xsl:if test="chars/ammo='true'">
        <td align="center"><xsl:value-of select="chars/ammo/@rocket"/>(rocket)</td>
      </xsl:if>
      </tr>
     </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>