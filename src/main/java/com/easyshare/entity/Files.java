package com.easyshare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author li-ji-ji
 * @since 2023-07-21
 */
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String fileName;

    private String filePath;

    private String fileType;

    private String uploadTime;

    private String expireTime;

    private Integer isTemporary;

    private Integer isEncrypt;

    private String secret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getIsTemporary() {
        return isTemporary;
    }

    public void setIsTemporary(Integer isTemporary) {
        this.isTemporary = isTemporary;
    }

    public Integer getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Integer isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Files{" +
            "id = " + id +
            ", fileName = " + fileName +
            ", filePath = " + filePath +
            ", fileType = " + fileType +
            ", uploadTime = " + uploadTime +
            ", expireTime = " + expireTime +
            ", isTemporary = " + isTemporary +
            ", isEncrypt = " + isEncrypt +
            ", secret = " + secret +
        "}";
    }
}
