package com.tvaprodut.saleweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "productlines")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductLines {

    @Id
    @Column(name="productCode", nullable=false, unique=true)
    private String productLine;

    @Column(name="textDescription")
    private String textDescription;

    @Column(name="htmlDescription")
    private String htmlDescription;

    @Column(name="image")
    private String image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
