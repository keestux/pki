package com.netscape.cmscore.dbs;

import com.netscape.certsrv.base.EBaseException;
import com.netscape.certsrv.base.ISubsystem;
import com.netscape.certsrv.dbs.EDBException;
import com.netscape.certsrv.dbs.IDBObj;
import com.netscape.certsrv.dbs.IDBSSession;
import com.netscape.certsrv.dbs.IDBSearchResults;
import com.netscape.certsrv.dbs.IDBVirtualList;
import com.netscape.certsrv.dbs.ModificationSet;

import netscape.ldap.LDAPSearchResults;

/**
 * A default stub ojbect for tests to extend.
 */
public class DBSSessionDefaultStub implements IDBSSession {

    public ISubsystem getDBSubsystem() {
        return null;
    }

    public void close() throws EDBException {
    }

    public void add(String name, IDBObj obj) throws EBaseException {
    }

    public IDBObj read(String name) throws EBaseException {
        return null;
    }

    public IDBObj read(String name, String attrs[]) throws EBaseException {
        return null;
    }

    public void delete(String name) throws EBaseException {
    }

    public void modify(String name, ModificationSet mods) throws EBaseException {
    }

    public IDBSearchResults search(String base, String filter) throws EBaseException {
        return null;
    }

    public IDBSearchResults search(String base, String filter, int maxSize) throws EBaseException {
        return null;
    }

    public IDBSearchResults search(String base, String filter, int maxSize, int timeLimit) throws EBaseException {
        return null;
    }

    public IDBSearchResults search(String base, String filter, String attrs[]) throws EBaseException {
        return null;
    }

    public <T extends IDBObj> IDBVirtualList<T> createVirtualList(String base, String filter, String attrs[]) throws EBaseException {
        return null;
    }

    public LDAPSearchResults persistentSearch(String base, String filter, String attrs[]) throws EBaseException {
        return null;
    }

    public void abandon(LDAPSearchResults results) throws EBaseException {
    }

    public <T extends IDBObj> IDBVirtualList<T> createVirtualList(String base, String filter, String attrs[], String sortKey, int pageSize)
            throws EBaseException {
        return null;
    }

    public <T extends IDBObj> IDBVirtualList<T> createVirtualList(String base, String filter, String attrs[], String sortKeys[], int pageSize)
            throws EBaseException {
        return null;
    }

    public <T extends IDBObj> IDBVirtualList<T> createVirtualList(String base, String filter, String attrs[], String startFrom,
            String sortKey, int pageSize) throws EBaseException {
        return null;
    }

    @Override
    public IDBSearchResults search(String base, String filter, int maxSize, int timeLimit, String sortAttribute)
            throws EBaseException {
        return null;
    }

    @Override
    public IDBSearchResults search(String base, String filter, int maxSize, String sortAttribute) throws EBaseException {
        return null;
    }
}
