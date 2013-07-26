<xsl:stylesheet version="1.0"
    xmlns:fn="http://www.w3.org/2005/xpath-functions"
    xmlns:tcm="http://www.tridion.com/ContentManager/5.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    exclude-result-prefixes="fn tcm xsl">

  <xsl:output omit-xml-declaration="yes" method="html" />

  <xsl:param name="PageUri" />

  <xsl:template match="/">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="tcm:Item[tcm:Item/@ID=$PageUri]">
    <xsl:call-template name="output-parent-sg">
      <xsl:with-param name="parent-node" select="."/>
    </xsl:call-template>

    <xsl:call-template name="output-sg">
      <xsl:with-param name="parent-node" select="."/>
    </xsl:call-template>

    <xsl:call-template name="output-page">
      <xsl:with-param name="parent-node" select="."/>
    </xsl:call-template>

    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template name="output-parent-sg">
    <xsl:param name="parent-node"/>
    <xsl:if test="$parent-node/../@Url">
      <ul>
        <li>
          &lt;-- <a href="{$parent-node/../@Url}/index.html"><xsl:value-of select="$parent-node/../@DisplayTitle"/></a>
        </li>
      </ul>
    </xsl:if>
  </xsl:template>

  <xsl:template name="output-sg">
    <xsl:param name="parent-node"/>
    <ul>
      <xsl:for-each select="$parent-node/tcm:Item[fn:ends-with(string(@ID),'-4')]">
        <xsl:sort select="@Title"/>
        <li>
          <a href="{@Url}/index.html"><xsl:value-of select="@DisplayTitle"/></a> --&gt;
        </li>
      </xsl:for-each>
    </ul>
  </xsl:template>

  <xsl:template name="output-page">
    <xsl:param name="parent-node"/>
    <ul>
      <xsl:for-each select="$parent-node/tcm:Item[fn:ends-with(string(@ID),'-64')]">
        <xsl:sort select="@Title"/>
        <li>
          <xsl:choose>
            <xsl:when test="@ID=$PageUri">
              <b><xsl:value-of select="@DisplayTitle"/></b>
            </xsl:when>
            <xsl:otherwise>
              <a href="{@Url}"><xsl:value-of select="@DisplayTitle"/></a>
            </xsl:otherwise>
          </xsl:choose>
        </li>
      </xsl:for-each>
    </ul>
  </xsl:template>

</xsl:stylesheet>