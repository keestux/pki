//--- BEGIN COPYRIGHT BLOCK ---
//This program is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; version 2 of the License.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License along
//with this program; if not, write to the Free Software Foundation, Inc.,
//51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
//(C) 2014 Red Hat, Inc.
//All rights reserved.
//--- END COPYRIGHT BLOCK ---
package com.netscape.certsrv.key;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.netscape.certsrv.base.ResourceMessage;

@XmlRootElement(name = "AsymKeyGenerationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AsymKeyGenerationRequest extends KeyGenerationRequest  {

    // Asymmetric Key Usages
    public static final String ENCRYPT = "encrypt";
    public static final String DECRYPT = "decrypt";
    public static final String SIGN = "sign";
    public static final String SIGN_RECOVER = "sign_recover";
    public static final String VERIFY = "verify";
    public static final String VERIFY_RECOVER = "verify_recover";
    public static final String WRAP = "wrap";
    public static final String UNWRAP = "unwrap";
    public static final String DERIVE = "derive";

    public AsymKeyGenerationRequest() {
        // required for JAXB (defaults)
        setClassName(getClass().getName());
    }

    public AsymKeyGenerationRequest(MultivaluedMap<String, String> form) {
        attributes.put(CLIENT_KEY_ID, form.getFirst(CLIENT_KEY_ID));
        attributes.put(KEY_SIZE, form.getFirst(KEY_SIZE));
        attributes.put(KEY_ALGORITHM, form.getFirst(KEY_ALGORITHM));
        attributes.put(KEY_USAGE, form.getFirst(KEY_USAGE));
        attributes.put(TRANS_WRAPPED_SESSION_KEY, form.getFirst(TRANS_WRAPPED_SESSION_KEY));
        attributes.put(REALM,  form.getFirst(REALM));

        String usageString = attributes.get(KEY_USAGE);
        if (!StringUtils.isBlank(usageString)) {
            setUsages(new ArrayList<>(Arrays.asList(usageString.split(","))));
        }
        setClassName(getClass().getName());
    }

    public AsymKeyGenerationRequest(ResourceMessage data) {
        attributes.putAll(data.getAttributes());
        setClassName(getClass().getName());
    }

    @Override
    public String toString() {
        try {
            return ResourceMessage.marshal(this, AsymKeyGenerationRequest.class);
        } catch (Exception e) {
            return super.toString();
        }
    }

    public static AsymKeyGenerationRequest valueOf(String string) throws Exception {
        try {
            return ResourceMessage.unmarshal(string, AsymKeyGenerationRequest.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> getValidUsagesList() {
        List<String> list = new ArrayList<>();
        list.add(DERIVE);
        list.add(SIGN);
        list.add(DECRYPT);
        list.add(ENCRYPT);
        list.add(WRAP);
        list.add(UNWRAP);
        list.add(SIGN_RECOVER);
        list.add(VERIFY);
        list.add(VERIFY_RECOVER);

        return list;
    }

    public String toXML() throws Exception {
        Marshaller marshaller = JAXBContext.newInstance(AsymKeyGenerationRequest.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }

    public static AsymKeyGenerationRequest fromXML(String xml) throws Exception {
        Unmarshaller unmarshaller = JAXBContext.newInstance(AsymKeyGenerationRequest.class).createUnmarshaller();
        return (AsymKeyGenerationRequest) unmarshaller.unmarshal(new StringReader(xml));
    }

}
