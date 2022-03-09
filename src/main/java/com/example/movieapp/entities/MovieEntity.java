package com.example.movieapp.entities;

import javax.persistence.*;


@Entity
@Table(name = "Film")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Tytuł", length = 100, nullable = false, unique = true)
    private String title;
    @Column(name="Rok_produkcji", length = 4, nullable = false)
    private int productionYear;
    @Column(name="Czas_trwania", length = 8, nullable = false)
    private String duration;
    @Column(name="Cena", length = 10, nullable = false)
    private double price;

    public MovieEntity(long id, String title, int productionYear, String duration, double price) {
        this.id = id;
        this.title = title;
        this.productionYear = productionYear;
        this.duration = duration;
        this.price = price;
    }

    public MovieEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
