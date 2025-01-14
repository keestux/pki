/**
 *
 */
package com.netscape.certsrv.system;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netscape.certsrv.util.JSONSerializer;

/**
 * @author alee
 */
@XmlRootElement(name="SecurityDomainSubsystem")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
 public class SecurityDomainSubsystem implements JSONSerializer {

    String name;
    Map<String, SecurityDomainHost> hosts = new LinkedHashMap<>();

    @XmlAttribute(name="id")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, SecurityDomainHost> getHosts() {
        return hosts;
    }

    @XmlElement(name="hosts")
    public void setHosts(Map<String, SecurityDomainHost> hosts) {
        this.hosts.clear();
        this.hosts.putAll(hosts);
    }

    /**
     * @return the hosts
     */
    @XmlElement(name="Host")
    @JsonProperty("Host")
    public SecurityDomainHost[] getHostArray() {
        return hosts.values().toArray(new SecurityDomainHost[hosts.size()]);
    }

    /**
     * @param hosts the system to set
     */
    public void setHostArray(SecurityDomainHost[] hosts) {
        this.hosts.clear();
        for (SecurityDomainHost host : hosts) {
            addHost(host);
        }
    }

    public void addHost(SecurityDomainHost host) {
        hosts.put(host.getId(), host);
    }

    public void removeHost(String hostId) {
        hosts.remove(hostId);
    }

    public String toXML() throws Exception {
        StringWriter sw = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(SecurityDomainSubsystem.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, sw);
        return sw.toString();
    }

    public static SecurityDomainSubsystem fromXML(String string) throws Exception {
        Unmarshaller unmarshaller = JAXBContext.newInstance(SecurityDomainSubsystem.class).createUnmarshaller();
        return (SecurityDomainSubsystem)unmarshaller.unmarshal(new StringReader(string));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hosts == null) ? 0 : hosts.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SecurityDomainSubsystem other = (SecurityDomainSubsystem) obj;
        if (hosts == null) {
            if (other.hosts != null)
                return false;
        } else if (!hosts.equals(other.hosts))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
