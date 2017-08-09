package com.cdk.controller;

import com.cdk.dao.BranchDao;
import com.cdk.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;
import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

@RestController
public class BranchServices {


    @Autowired
    BranchDao branchDao;

    @RequestMapping(value = "/branch/{branchId}", method = RequestMethod.GET, produces = TEXT_PLAIN_VALUE )
    public String getBranchDetailsAsPlainText(@PathVariable("branchId") int branchId) {
        Bank bank = branchDao.getBranchDetails(branchId);
        return bank.toString();
    }

    @RequestMapping(value = "/branch/{branchId}", method = RequestMethod.GET, produces = APPLICATION_XML_VALUE )
    public Bank getBranchDetailsAsXML(@PathVariable("branchId") int branchId) {
        return branchDao.getBranchDetails(branchId);
    }

    @RequestMapping(value = "/branch/{branchId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE )
    public Bank getBranchDetailsAsJSON(@PathVariable("branchId") int branchId) {
        return branchDao.getBranchDetails(branchId);
    }

}
