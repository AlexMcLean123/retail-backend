package com.murex.retail.experience;

public class ComputerComponent {
    public static class ComputerComponentBuilder {
        private String id;
        private String category;
        private String name;
        private String brand;
        private String productLine;
        private String coreNum;
        private String procSpeed;
        private String graphicSpeed;
        private String dimension;
        private String res;
        private String color;
        private String interf;
        private String size;
        private int price;
        private int quantity;

        public ComputerComponentBuilder (){
        }

        public ComputerComponentBuilder id(String id ){
            this.id=id;
            return this;
        }
        public ComputerComponentBuilder category(String category ){
            this.category=category;
            return this;
        }
        public ComputerComponentBuilder name(String name){
            this.name=name;
            return this;
        }
        public ComputerComponentBuilder brand(String brand){
            this.brand=brand;
            return this;
        }
        public ComputerComponentBuilder productLine(String productLine){
            this.productLine=productLine;
            return this;
        }
        public ComputerComponentBuilder coreNum(String coreNum){
            this.coreNum=coreNum;
            return this;
        }
        public ComputerComponentBuilder procSpeed (String procSpeed){
            this.procSpeed=procSpeed;
            return this;
        }
        public ComputerComponentBuilder graphicSpeed(String graphicSpeed){
            this.graphicSpeed=graphicSpeed;
            return this;
        }
        public ComputerComponentBuilder dimension(String dimension){
            this.dimension=dimension;
            return this;
        }
        public ComputerComponentBuilder res(String res){
            this.res=res;
            return this;
        }
        public ComputerComponentBuilder color(String color){
            this.color=color;
            return this;
        }
        public ComputerComponentBuilder interf(String interf){
            this.interf=interf;
            return this;
        }
        public ComputerComponentBuilder size(String size){
            this.size= size;
            return this;
        }
        public ComputerComponentBuilder price(int price){
            this.price=price;
            return this;
        }
        public ComputerComponentBuilder quantity(int quantity){
            this.quantity=quantity;
            return this;
        }

        public ComputerComponent build(){
            return new ComputerComponent(this);
        }
    }
    private String id;
    private String category;
    private String name;
    private String brand;
    private String productLine;
    private String coreNum;
    private String procSpeed;
    private String graphicSpeed;
    private String dimension;
    private String res;
    private String color;
    private String interf;
    private String size;
    private int price;
    private int quantity;

    public ComputerComponent (ComputerComponentBuilder builder) {
        this.id=builder.id;
        this.category=builder.category;
        this.name=builder.name;
        this.brand=builder.brand;
        this.productLine=builder.productLine;
        this.coreNum=builder.coreNum;
        this.procSpeed=builder.procSpeed;
        this.graphicSpeed=builder.graphicSpeed;
        this.dimension =builder.dimension;
        this.res =builder.res;
        this.color = builder.color;
        this.interf=builder.interf;
        this.size =builder.size;
        this.price =builder.price;
        this.quantity=builder.quantity;
    }

    public String getID(){
        return id;
    }
    public String getCategory(){
        return category;
    }
    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
    public String getProductLine(){
        return productLine;
    }
    public String getCoreNum(){
        return coreNum;
    }
    public String getGraphicSpeed(){
        return graphicSpeed;
    }
    public String getDimension(){
        return dimension;
    }
    public String getRes(){
        return res;
    }
    public String getColor(){
        return color;
    }
    public String getInterf(){
        return interf;
    }
    public String getSize(){
        return size;
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public String toString(){
        String s1;
        s1 = id + "\t|\t"+ category + "\t|\t" + name +"\t|\t"+ brand + "\t|\t" +
                productLine + "\t|\t" + coreNum + "\t|\t" + procSpeed + "\t|\t"
                + graphicSpeed +"\t|\t" + dimension+ "\t|\t" + res + "\t|" + color + "\t|\t"
                + interf + "\t|\t" + size + "\t|\t" + price + "\t|\t" + quantity;
        return s1;
    }
}