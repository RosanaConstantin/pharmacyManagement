<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Gestiunea medicamentelor</h2>
  <xsl:for-each select="farmacie/reteta">
	<h1>Reteta: <xsl:value-of select="@serie"/> </h1>
	
	 <table border="1">
		<tr bgcolor="#9acd32">
			<th style="text-align:left" colspan="4">Tipul retetei</th>
			<th style="text-align:left" colspan="4">Diagnostic</th>
			<th style="text-align:left" colspan="4">Data eliberarii</th>
			<th style="text-align:left" colspan="4">Medic</th>
			<th style="text-align:left" colspan="4">Pacient</th>
			<th style="text-align:left" colspan="8">Medicamente</th>
		</tr>
	  
		<tr>
			<td colspan="4" rowspan="12"><xsl:value-of select="@tip"/></td>
			<td colspan="4" rowspan="12"><xsl:value-of select="diagnostic/@cod"/></td>
			<td colspan="4" rowspan="12"><xsl:value-of select="dataEliberarii"/></td>
			<td colspan="4" rowspan="12">Nume: <xsl:value-of select="medic/@nume"/>
										<p/>Specializare: <xsl:value-of select="medic/specializare"/>
			</td>
			<td colspan="4" rowspan="12">Nume:<xsl:value-of select="pacient/nume"/>
										<p/>Sex: <xsl:value-of select="pacient/sex"/>
										<p/>CNP: <xsl:value-of select="pacient/cnp"/>
										<p/>Beneficiar: <xsl:value-of select="pacient/tipBeneficiar"/>
			</td>
			<tr bgcolor="#9acd32">
				<th style="text-align:left" colspan="2">Denumire</th>
				<th style="text-align:left" colspan="2">Cantitate</th>
				<th style="text-align:left" colspan="2">Dozaj</th>
				<th style="text-align:left" colspan="2">Compensare(%)</th>
			</tr>
			<xsl:for-each select="listaMedicamente/medicament">
				<tr>
					<td colspan="2"><xsl:value-of select="denumire"/></td>
					<td colspan="2"><xsl:value-of select="cantitate"/></td>
					<td colspan="2"><xsl:value-of select="dozaj"/></td>
					<td colspan="2"><xsl:value-of select="compensare"/></td>
				</tr>
			</xsl:for-each>
		</tr>
	 </table>
  </xsl:for-each>
 
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>