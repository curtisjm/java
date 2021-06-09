package sample;

public class ItemToDo {
    private String itemName;
    private String date;

    public ItemToDo (String itemName, String date){
        this.itemName = itemName;
        this.date = date;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

}

