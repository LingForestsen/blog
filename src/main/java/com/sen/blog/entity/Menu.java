package com.sen.blog.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: Sen
 * @Date: 2019/9/27 01:26
 * @Description: 菜单
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 6432153098640890314L;

    private int menuId;

    @NotNull(message = "菜单名不能为空")
    private String menuName;

    @NotNull(message = "菜单url不能为空")
    private String menuUrl;

    /**
     * 菜单位置
     */
    private int menuLevel;

    private String menuIcon;

    private int menuOrder;

    public Menu() {
    }

    public Menu(int menuId) {
        this.menuId = menuId;
    }
}
