package org.pluto.langgraph4j.tool;

import dev.langchain4j.agent.tool.Tool;

public class Calculator {

    @Tool("加法")
    public int add(int a, int b) { return a + b; }

    @Tool("乘法")
    public int mul(int a, int b) { return a * b; }

}
