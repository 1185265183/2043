package cn.web.security.pojo;

public class Temporaryrules {
    private String rkey;

    private String hook;

    private Integer level;

    private String warning;

    private String suggestion;

    private String category;

    private String other;

    private String input;

    private String checkForNull;

    private String formatPosition;

    private String extractLookahead;

    public String getRkey() {
        return rkey;
    }

    public void setRkey(String rkey) {
        this.rkey = rkey == null ? null : rkey.trim();
    }

    public String getHook() {
        return hook;
    }

    public void setHook(String hook) {
        this.hook = hook == null ? null : hook.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning == null ? null : warning.trim();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
    }

    public String getCheckForNull() {
        return checkForNull;
    }

    public void setCheckForNull(String checkForNull) {
        this.checkForNull = checkForNull == null ? null : checkForNull.trim();
    }

    public String getFormatPosition() {
        return formatPosition;
    }

    public void setFormatPosition(String formatPosition) {
        this.formatPosition = formatPosition == null ? null : formatPosition.trim();
    }

    public String getExtractLookahead() {
        return extractLookahead;
    }

    public void setExtractLookahead(String extractLookahead) {
        this.extractLookahead = extractLookahead == null ? null : extractLookahead.trim();
    }
}