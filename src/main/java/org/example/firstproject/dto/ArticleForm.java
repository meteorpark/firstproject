package org.example.firstproject.dto;

public class ActionForm {
    private String title;

    @Override
    public String toString() {
        return "ActionForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    private String content;

    public ActionForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
