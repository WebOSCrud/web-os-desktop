package cn.donting.web.os.desktop.controller;

import cn.donting.web.os.desktop.domain.ResponseBody;
import cn.donting.web.os.desktop.exception.ResponseBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import javax.naming.LimitExceededException;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class BaseErrorController {


    @ExceptionHandler(value = Exception.class)
    public ResponseBody fileUploadExceptionHandler(HttpServletResponse response, Exception exception) {
        log.error(exception.getMessage(), exception);
        response.setStatus(500);
        ResponseBody fail = ResponseBody.fail(500, exception.getLocalizedMessage());
        return fail;
    }

    @ExceptionHandler(value = ResponseBodyException.class)
    public ResponseBody responseBodyException(HttpServletResponse response, ResponseBodyException exception) {
//        log.error(exception.getMessage(),exception);
        response.setStatus(500);
        ResponseBody fail = exception.getResponseBody();
        return fail;
    }
}
