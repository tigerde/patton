package com.company.project.model;

import javax.persistence.*;

public class Users {
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD_HASH")
    private String passwordHash;

    @Column(name = "PASSWORD_SALT")
    private Long passwordSalt;

    @Column(name = "PASSWORD_LOGIN")
    private Boolean passwordLogin;

    @Column(name = "OPTIMISTIC_LOCK_VERSION")
    private Long optimisticLockVersion;

    /**
     * @return USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return PASSWORD_HASH
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * @return PASSWORD_SALT
     */
    public Long getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * @param passwordSalt
     */
    public void setPasswordSalt(Long passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * @return PASSWORD_LOGIN
     */
    public Boolean getPasswordLogin() {
        return passwordLogin;
    }

    /**
     * @param passwordLogin
     */
    public void setPasswordLogin(Boolean passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    /**
     * @return OPTIMISTIC_LOCK_VERSION
     */
    public Long getOptimisticLockVersion() {
        return optimisticLockVersion;
    }

    /**
     * @param optimisticLockVersion
     */
    public void setOptimisticLockVersion(Long optimisticLockVersion) {
        this.optimisticLockVersion = optimisticLockVersion;
    }
}