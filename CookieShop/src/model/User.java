package model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private boolean isadmin = false;
    private boolean isvalidate = false;

    public User() {
    }

    public User(int id, String username, String email, String password, String name, String phone, String address, boolean isadmin, boolean isvalidate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isadmin = isadmin;
        this.isvalidate = isvalidate;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return isadmin
     */
    public boolean isIsadmin() {
        return isadmin;
    }

    /**
     * 设置
     * @param isadmin
     */
    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    /**
     * 获取
     * @return isvalidate
     */
    public boolean isIsvalidate() {
        return isvalidate;
    }

    /**
     * 设置
     * @param isvalidate
     */
    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", email = " + email + ", password = " + password + ", name = " + name + ", phone = " + phone + ", address = " + address + ", isadmin = " + isadmin + ", isvalidate = " + isvalidate + "}";
    }
}
