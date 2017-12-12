GreenDAO ORM 基本範例
===
HKT 線上教室 每週六日 更新影片

▶ YouTube 頻道
https://goo.gl/3f2pJi

▶ KT 線上教室 臉書粉絲團
https://goo.gl/27H9Li

▶ 贊助我們
https://goo.gl/FiKXAu

▶2017 Android 中文開放式課程 目錄
https://goo.gl/Ti8mGA

Android 8 Oreo / Android Studio 
Android 教學 / 開發


GreenDAO 基本讀取、新增、修改、刪除範例說明：

![](https://i.imgur.com/i0HVPkC.png)

## 點擊「讀取」按鈕功能
可以在 Logcat 看到，撈取 Note 資料表資料。
![](https://i.imgur.com/h2s27k2.png)
(預設Note 資料表為空)

## 點擊「新增」按鈕功能
在第一個文字框，輸入筆記資料，點擊新增，將會把此筆文字資料寫入 Note 資料表中。

新增後，可以點擊「讀取」按鈕，確認資料是否正確寫入。

## 點擊「修改」按鈕功能
在第二個文字框，輸入筆記id 資料，在第一個文字框，輸入欲修改筆記資料，點擊修改，將會修改此筆文字資料。

修改後，可以點擊「讀取」按鈕，確認資料是否正確寫入。
## 點擊「刪除」按鈕功能
在第二個文字框，輸入筆記id 資料，將會修改此筆文字資料。
刪除後，可以點擊「讀取」按鈕，確認資料是否正確寫入。
## 點擊「刪除全部資料」按鈕功能
將會刪除所有資料表資料。
刪除全部資料後，可以點擊「讀取」按鈕，確認資料是否正確寫入。

---

# 程式碼，加入關鍵點

## Gradle
## build.gradle (Project)
```jsx
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2'
    }
}
```
## build.gradle (Module)
```jsx
apply plugin: 'org.greenrobot.greendao'

greendao {
    schemaVersion 1
}

dependencies {
    compile 'org.greenrobot:greendao:3.2.2'
}
```
## 宣告一個 Entity class

```jsx
@Entity
public class Note {
    @Id
    private Long id;

    @NotNull
    private String text;
}
```
## "build"->"Make Project"
將會自動生成檔案

![](https://i.imgur.com/yMANaRl.png)

## 透過 Application 單例模式，存取資料庫
```jsx
public class App extends Application {
    private static App sInstance;

    public static synchronized App getInstance() {
        return sInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        //單例模式，存取資料庫
        DBHelper.setInstance(getApplicationContext());
    }
}
```

## 新增一個 DBHelper，來管理存取資料庫
```jsx
public class DBHelper extends DaoMaster.DevOpenHelper {
...
}
```
## 獲取全部「筆記」資料

```jsx
List<Note> note_List = getNoteDao().queryBuilder().list();

```
## 新增「筆記」資料

```jsx
Note note = new Note();
note.setText(txtNote);
getNoteDao().insert(note);

```

## 修改「筆記」資料
```jsx
Note note = getNoteDao().queryBuilder().where(NoteDao.Properties.Id.eq(id)).unique();
note.setText(txtNote);
getNoteDao().update(note);
```

## 刪除「筆記」資料
```jsx
getNoteDao().deleteByKey(id);
```

## 刪除所有「筆記」資料
```jsx
getNoteDao().deleteAll();
```





---
參考資料：
[greenDAO 官方說明文件](http://greenrobot.org/greendao/)
