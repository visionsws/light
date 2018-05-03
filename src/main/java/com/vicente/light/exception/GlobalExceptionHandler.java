package com.vicente.light.exception;

import com.vicente.light.common.CommonConstant;
import com.vicente.light.dto.ResponseDto;
import com.vicente.light.util.ResultUtil;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shiweisen
 * @since 2018-01-24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseDto methodArgumentNotValid2(HttpServletRequest req, MethodArgumentNotValidException  ex)  {
        String message = "";
        ServletContext servletContext = req.getServletContext();
        //WebApplicationContext context = (WebApplicationContext)servletContext.getAttribute(CONTEXT_ATTRIBUTE);
        String exceptionCode = "";
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        if (errors.size() > 0) {
            exceptionCode = errors.get(0).getDefaultMessage();
        }
        Object[] params = {"Jhon",new Date()};
        message = message + messageSource.getMessage(exceptionCode, params, ex.getMessage(), req.getLocale());
        logger.error("---MethodArgumentNotValidException Handler--- ERROR: {}", message);
        return ResultUtil.error(CommonConstant.RESPONSE_CODE_NOT_VALID,message);
    }


    /*@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseDto methodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException  ex)  {
        List<ObjectError> errors =ex.getBindingResult().getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        logger.error("---MethodArgumentNotValidException Handler--- ERROR: {}", errorMsg.toString());
        return ResultUtil.error(CommonConstant.RESPONSE_CODE_NOT_VALID,errorMsg.toString());
    }*/

    @ExceptionHandler(value = LightException.class)
    public ResponseDto baseErrorHandler(HttpServletRequest req, Exception e)  {
        logger.error("---LightException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return ResultUtil.error(CommonConstant.RESPONSE_CODE_NOT_EXIST,e.getMessage());
    }

  /*  @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return ResultUtil.error(CommonConstant.RESPONSE_CODE_UNKNOW_EXCEPTION,e.getMessage());
    }*/

}
