package com.example.longforus.testinclude;

import com.longforus.stateview.IListBean;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * @author XQ Yang
 * @date 5/6/2018  1:39 PM
 */
public class ResultList implements IListBean<String> {
    public List<String> list;

    public ResultList(List<String> list) {
        this.list = list;
    }

    @NotNull
    @Override
    public List<String> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
