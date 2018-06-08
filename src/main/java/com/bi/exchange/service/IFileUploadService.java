package com.bi.exchange.service;


import com.bi.exchange.framework.web.response.ResponseWrapper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IFileUploadService {

    ResponseWrapper fileUpload(MultipartFile file, Map<String, Object> map);

}
