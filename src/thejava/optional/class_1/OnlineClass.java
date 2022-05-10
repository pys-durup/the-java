package thejava.optional.class_1;

import java.util.Optional;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
        getProgress() null을 리턴하는 그 자체가 문제이다
        1. 에러를 던지는 방법 - 런타임익셉션을 던지면 그나마 조금 클라이언트 쪽 코드 고통
        체크드익셉션을 던지면 에러처리를 강제하는 문제가 생기고
        에러가 발생하면 자바는 스택트레이스를 찍어두기 때문에 (에러가 발생하기 전까지 어떠한 콜스택을 거쳐서 에러가 발생하게 되었는지)
        그만큼의 리소스를 사용하게 된다
        ** 진짜 필요한 경우에만 예외를 써야지 로직을 처리할때 예외를 던지는 것은 좋은 습관이 아니다
        2. 그냥 null을 리턴하는 방법 - 클라이언트가 처리해야한다
     */
//    public Progress getProgress() {
//        if (this.progress == null) {
//            throw new IllegalStateException();
//        }
//        return progress;
//    }

    /*
        3. optional을 리턴한다
     */
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}

