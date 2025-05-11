package API.pojo;

public class todo {
    private String item;
    private Boolean isCompleted;

    public todo(String item, Boolean isCompleted) {
        this.item = item;
        this.isCompleted = isCompleted;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}

