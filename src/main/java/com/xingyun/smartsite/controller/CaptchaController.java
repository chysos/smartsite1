package com.xingyun.smartsite.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xingyun.smartsite.utils.CaptchaUtil;

//返回验证码图片
@RestController
@RequestMapping("/captcha")

public class CaptchaController {
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    @ResponseBody
    public void getValidateCode(Integer width, Integer height,
                                HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            // 不缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);

            HttpSession session = request.getSession();

            CaptchaUtil tool = new CaptchaUtil();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            System.err.println(code);
            session.removeAttribute(CaptchaUtil.KEY_CAPTCHA);
            session.setAttribute(CaptchaUtil.KEY_CAPTCHA, code.toString());

            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
