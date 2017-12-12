package com.calvin.demogreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Entity mapped to table "NOTE".
 */
@Entity
public class Note {

    @Id
    private Long id;

    @NotNull
    private String text;

    @Generated(hash = 990389247)
    public Note(Long id, @NotNull String text) {
        this.id = id;
        this.text = text;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
