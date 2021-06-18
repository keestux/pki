package com.netscape.certsrv.authority;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorityDataTest {

    private static AuthorityData before = new AuthorityData();

    @Before
    public void setUpBefore() {
        before.setDescription("Test AuthorityData");
        before.setDn("dn");
        before.setEnabled(true);
        before.setId("testuser");
        before.setIsHostAuthority(true);
        before.setIssuerDN("issuerDN");
        before.setParentID("parentID");
        before.setReady(false);
        before.setSerial(BigInteger.valueOf(1));
    }

    @Test
    public void testXML() throws Exception {
        // Act
        String xml = before.toXML();
        System.out.println("XML (before): " + xml);

        AuthorityData afterXML = AuthorityData.fromXML(xml);
        System.out.println("XML (after): " + afterXML.toXML());

        // Assert
        Assert.assertEquals(before, afterXML);
    }

    @Test
    public void testJSON() throws Exception {
        // Act
        String json = before.toJSON();
        System.out.println("JSON (before): " + json);

        AuthorityData afterJSON = AuthorityData.fromJSON(json);
        System.out.println("JSON (after): " + afterJSON.toJSON());

        // Assert
        Assert.assertEquals(before, afterJSON);
    }

}
