package com.guimei.shop.action;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.dao.CustomerDao;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.framework.ActionSupport;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * by wangrongjun on 2017/6/22.
 */
public class UploadImageAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();

        String url = "admin/img/customer_" + customer.getCustomerId() + ".jpg";
        String savePath = request.getServletContext().getRealPath(url);
        System.out.println(savePath);
        /*
         * ״̬��
         * 0���ϴ��ɹ�
         * 1����С����1M
         * 2��δ֪����
         */
        int state;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //�����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
            upload.setFileSizeMax(1024 * 1024);
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                InputStream is = item.getInputStream();
                FileOutputStream fos = new FileOutputStream(savePath);
                byte[] buf = new byte[1024];
                int len;
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                is.close();
                fos.close();
                item.delete();
            }
            state = 0;
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            state = 1;
        } catch (Exception e) {
            state = 2;
            e.printStackTrace();
        }

        switch (state) {
            case 0:
                CustomerDao customerDao = DaoFactory.getCustomerDao();
                customerDao.updateHeadUrl(customer.getCustomerId(), url);
                customer.setHeadUrl(url);
                request.setAttribute("msg", "�ϴ��ɹ�");
                break;
            case 1:
                request.setAttribute("msg", "�ϴ�ʧ�ܣ�ͼƬ��С���ܳ���1MB");
                break;
            case 2:
                request.setAttribute("msg", "�ϴ�ʧ�ܣ�δ֪�쳣");
                break;
        }
        return "customer_info.jsp";
    }
}
