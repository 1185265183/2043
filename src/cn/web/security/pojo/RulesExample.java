package cn.web.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class RulesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RulesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRkeyIsNull() {
            addCriterion("rkey is null");
            return (Criteria) this;
        }

        public Criteria andRkeyIsNotNull() {
            addCriterion("rkey is not null");
            return (Criteria) this;
        }

        public Criteria andRkeyEqualTo(String value) {
            addCriterion("rkey =", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyNotEqualTo(String value) {
            addCriterion("rkey <>", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyGreaterThan(String value) {
            addCriterion("rkey >", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyGreaterThanOrEqualTo(String value) {
            addCriterion("rkey >=", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyLessThan(String value) {
            addCriterion("rkey <", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyLessThanOrEqualTo(String value) {
            addCriterion("rkey <=", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyLike(String value) {
            addCriterion("rkey like", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyNotLike(String value) {
            addCriterion("rkey not like", value, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyIn(List<String> values) {
            addCriterion("rkey in", values, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyNotIn(List<String> values) {
            addCriterion("rkey not in", values, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyBetween(String value1, String value2) {
            addCriterion("rkey between", value1, value2, "rkey");
            return (Criteria) this;
        }

        public Criteria andRkeyNotBetween(String value1, String value2) {
            addCriterion("rkey not between", value1, value2, "rkey");
            return (Criteria) this;
        }

        public Criteria andHookIsNull() {
            addCriterion("hook is null");
            return (Criteria) this;
        }

        public Criteria andHookIsNotNull() {
            addCriterion("hook is not null");
            return (Criteria) this;
        }

        public Criteria andHookEqualTo(String value) {
            addCriterion("hook =", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookNotEqualTo(String value) {
            addCriterion("hook <>", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookGreaterThan(String value) {
            addCriterion("hook >", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookGreaterThanOrEqualTo(String value) {
            addCriterion("hook >=", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookLessThan(String value) {
            addCriterion("hook <", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookLessThanOrEqualTo(String value) {
            addCriterion("hook <=", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookLike(String value) {
            addCriterion("hook like", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookNotLike(String value) {
            addCriterion("hook not like", value, "hook");
            return (Criteria) this;
        }

        public Criteria andHookIn(List<String> values) {
            addCriterion("hook in", values, "hook");
            return (Criteria) this;
        }

        public Criteria andHookNotIn(List<String> values) {
            addCriterion("hook not in", values, "hook");
            return (Criteria) this;
        }

        public Criteria andHookBetween(String value1, String value2) {
            addCriterion("hook between", value1, value2, "hook");
            return (Criteria) this;
        }

        public Criteria andHookNotBetween(String value1, String value2) {
            addCriterion("hook not between", value1, value2, "hook");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andWarningIsNull() {
            addCriterion("warning is null");
            return (Criteria) this;
        }

        public Criteria andWarningIsNotNull() {
            addCriterion("warning is not null");
            return (Criteria) this;
        }

        public Criteria andWarningEqualTo(String value) {
            addCriterion("warning =", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotEqualTo(String value) {
            addCriterion("warning <>", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningGreaterThan(String value) {
            addCriterion("warning >", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningGreaterThanOrEqualTo(String value) {
            addCriterion("warning >=", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningLessThan(String value) {
            addCriterion("warning <", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningLessThanOrEqualTo(String value) {
            addCriterion("warning <=", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningLike(String value) {
            addCriterion("warning like", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotLike(String value) {
            addCriterion("warning not like", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningIn(List<String> values) {
            addCriterion("warning in", values, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotIn(List<String> values) {
            addCriterion("warning not in", values, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningBetween(String value1, String value2) {
            addCriterion("warning between", value1, value2, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotBetween(String value1, String value2) {
            addCriterion("warning not between", value1, value2, "warning");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNull() {
            addCriterion("suggestion is null");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNotNull() {
            addCriterion("suggestion is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestionEqualTo(String value) {
            addCriterion("suggestion =", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotEqualTo(String value) {
            addCriterion("suggestion <>", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThan(String value) {
            addCriterion("suggestion >", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThanOrEqualTo(String value) {
            addCriterion("suggestion >=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThan(String value) {
            addCriterion("suggestion <", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThanOrEqualTo(String value) {
            addCriterion("suggestion <=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLike(String value) {
            addCriterion("suggestion like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotLike(String value) {
            addCriterion("suggestion not like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionIn(List<String> values) {
            addCriterion("suggestion in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotIn(List<String> values) {
            addCriterion("suggestion not in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionBetween(String value1, String value2) {
            addCriterion("suggestion between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotBetween(String value1, String value2) {
            addCriterion("suggestion not between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andInputIsNull() {
            addCriterion("input is null");
            return (Criteria) this;
        }

        public Criteria andInputIsNotNull() {
            addCriterion("input is not null");
            return (Criteria) this;
        }

        public Criteria andInputEqualTo(String value) {
            addCriterion("input =", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotEqualTo(String value) {
            addCriterion("input <>", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputGreaterThan(String value) {
            addCriterion("input >", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputGreaterThanOrEqualTo(String value) {
            addCriterion("input >=", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLessThan(String value) {
            addCriterion("input <", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLessThanOrEqualTo(String value) {
            addCriterion("input <=", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLike(String value) {
            addCriterion("input like", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotLike(String value) {
            addCriterion("input not like", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputIn(List<String> values) {
            addCriterion("input in", values, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotIn(List<String> values) {
            addCriterion("input not in", values, "input");
            return (Criteria) this;
        }

        public Criteria andInputBetween(String value1, String value2) {
            addCriterion("input between", value1, value2, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotBetween(String value1, String value2) {
            addCriterion("input not between", value1, value2, "input");
            return (Criteria) this;
        }

        public Criteria andCheckForNullIsNull() {
            addCriterion("check_for_null is null");
            return (Criteria) this;
        }

        public Criteria andCheckForNullIsNotNull() {
            addCriterion("check_for_null is not null");
            return (Criteria) this;
        }

        public Criteria andCheckForNullEqualTo(String value) {
            addCriterion("check_for_null =", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullNotEqualTo(String value) {
            addCriterion("check_for_null <>", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullGreaterThan(String value) {
            addCriterion("check_for_null >", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullGreaterThanOrEqualTo(String value) {
            addCriterion("check_for_null >=", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullLessThan(String value) {
            addCriterion("check_for_null <", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullLessThanOrEqualTo(String value) {
            addCriterion("check_for_null <=", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullLike(String value) {
            addCriterion("check_for_null like", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullNotLike(String value) {
            addCriterion("check_for_null not like", value, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullIn(List<String> values) {
            addCriterion("check_for_null in", values, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullNotIn(List<String> values) {
            addCriterion("check_for_null not in", values, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullBetween(String value1, String value2) {
            addCriterion("check_for_null between", value1, value2, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andCheckForNullNotBetween(String value1, String value2) {
            addCriterion("check_for_null not between", value1, value2, "checkForNull");
            return (Criteria) this;
        }

        public Criteria andFormatPositionIsNull() {
            addCriterion("format_position is null");
            return (Criteria) this;
        }

        public Criteria andFormatPositionIsNotNull() {
            addCriterion("format_position is not null");
            return (Criteria) this;
        }

        public Criteria andFormatPositionEqualTo(String value) {
            addCriterion("format_position =", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionNotEqualTo(String value) {
            addCriterion("format_position <>", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionGreaterThan(String value) {
            addCriterion("format_position >", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionGreaterThanOrEqualTo(String value) {
            addCriterion("format_position >=", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionLessThan(String value) {
            addCriterion("format_position <", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionLessThanOrEqualTo(String value) {
            addCriterion("format_position <=", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionLike(String value) {
            addCriterion("format_position like", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionNotLike(String value) {
            addCriterion("format_position not like", value, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionIn(List<String> values) {
            addCriterion("format_position in", values, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionNotIn(List<String> values) {
            addCriterion("format_position not in", values, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionBetween(String value1, String value2) {
            addCriterion("format_position between", value1, value2, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andFormatPositionNotBetween(String value1, String value2) {
            addCriterion("format_position not between", value1, value2, "formatPosition");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadIsNull() {
            addCriterion("extract_lookahead is null");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadIsNotNull() {
            addCriterion("extract_lookahead is not null");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadEqualTo(String value) {
            addCriterion("extract_lookahead =", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadNotEqualTo(String value) {
            addCriterion("extract_lookahead <>", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadGreaterThan(String value) {
            addCriterion("extract_lookahead >", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadGreaterThanOrEqualTo(String value) {
            addCriterion("extract_lookahead >=", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadLessThan(String value) {
            addCriterion("extract_lookahead <", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadLessThanOrEqualTo(String value) {
            addCriterion("extract_lookahead <=", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadLike(String value) {
            addCriterion("extract_lookahead like", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadNotLike(String value) {
            addCriterion("extract_lookahead not like", value, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadIn(List<String> values) {
            addCriterion("extract_lookahead in", values, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadNotIn(List<String> values) {
            addCriterion("extract_lookahead not in", values, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadBetween(String value1, String value2) {
            addCriterion("extract_lookahead between", value1, value2, "extractLookahead");
            return (Criteria) this;
        }

        public Criteria andExtractLookaheadNotBetween(String value1, String value2) {
            addCriterion("extract_lookahead not between", value1, value2, "extractLookahead");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}