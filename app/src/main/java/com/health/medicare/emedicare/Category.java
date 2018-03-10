package com.health.medicare.emedicare;



public class Category {
    int image;
    String categoryName;

    public Category(int categoryImage,String categoryNme)
    {
        image=categoryImage;
        categoryName=categoryNme;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return categoryName;
    }
}
