package cn.web.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class VarInfoViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public VarInfoViewExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andVIdIsNull() {
            addCriterion("var_info_view.v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("var_info_view.v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(Integer value) {
            addCriterion("var_info_view.v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(Integer value) {
            addCriterion("var_info_view.v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(Integer value) {
            addCriterion("var_info_view.v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(Integer value) {
            addCriterion("var_info_view.v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<Integer> values) {
            addCriterion("var_info_view.v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<Integer> values) {
            addCriterion("var_info_view.v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVNameIsNull() {
            addCriterion("var_info_view.v_name is null");
            return (Criteria) this;
        }

        public Criteria andVNameIsNotNull() {
            addCriterion("var_info_view.v_name is not null");
            return (Criteria) this;
        }

        public Criteria andVNameEqualTo(String value) {
            addCriterion("var_info_view.v_name =", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotEqualTo(String value) {
            addCriterion("var_info_view.v_name <>", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThan(String value) {
            addCriterion("var_info_view.v_name >", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_name >=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThan(String value) {
            addCriterion("var_info_view.v_name <", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_name <=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLike(String value) {
            addCriterion("var_info_view.v_name like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotLike(String value) {
            addCriterion("var_info_view.v_name not like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameIn(List<String> values) {
            addCriterion("var_info_view.v_name in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotIn(List<String> values) {
            addCriterion("var_info_view.v_name not in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameBetween(String value1, String value2) {
            addCriterion("var_info_view.v_name between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotBetween(String value1, String value2) {
            addCriterion("var_info_view.v_name not between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVModifierIsNull() {
            addCriterion("var_info_view.v_modifier is null");
            return (Criteria) this;
        }

        public Criteria andVModifierIsNotNull() {
            addCriterion("var_info_view.v_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andVModifierEqualTo(String value) {
            addCriterion("var_info_view.v_modifier =", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierNotEqualTo(String value) {
            addCriterion("var_info_view.v_modifier <>", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierGreaterThan(String value) {
            addCriterion("var_info_view.v_modifier >", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_modifier >=", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierLessThan(String value) {
            addCriterion("var_info_view.v_modifier <", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_modifier <=", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierLike(String value) {
            addCriterion("var_info_view.v_modifier like", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierNotLike(String value) {
            addCriterion("var_info_view.v_modifier not like", value, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierIn(List<String> values) {
            addCriterion("var_info_view.v_modifier in", values, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierNotIn(List<String> values) {
            addCriterion("var_info_view.v_modifier not in", values, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierBetween(String value1, String value2) {
            addCriterion("var_info_view.v_modifier between", value1, value2, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVModifierNotBetween(String value1, String value2) {
            addCriterion("var_info_view.v_modifier not between", value1, value2, "vModifier");
            return (Criteria) this;
        }

        public Criteria andVTypeIsNull() {
            addCriterion("var_info_view.v_type is null");
            return (Criteria) this;
        }

        public Criteria andVTypeIsNotNull() {
            addCriterion("var_info_view.v_type is not null");
            return (Criteria) this;
        }

        public Criteria andVTypeEqualTo(String value) {
            addCriterion("var_info_view.v_type =", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotEqualTo(String value) {
            addCriterion("var_info_view.v_type <>", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeGreaterThan(String value) {
            addCriterion("var_info_view.v_type >", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_type >=", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeLessThan(String value) {
            addCriterion("var_info_view.v_type <", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_type <=", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeLike(String value) {
            addCriterion("var_info_view.v_type like", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotLike(String value) {
            addCriterion("var_info_view.v_type not like", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeIn(List<String> values) {
            addCriterion("var_info_view.v_type in", values, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotIn(List<String> values) {
            addCriterion("var_info_view.v_type not in", values, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeBetween(String value1, String value2) {
            addCriterion("var_info_view.v_type between", value1, value2, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotBetween(String value1, String value2) {
            addCriterion("var_info_view.v_type not between", value1, value2, "vType");
            return (Criteria) this;
        }

        public Criteria andVValueIsNull() {
            addCriterion("var_info_view.v_value is null");
            return (Criteria) this;
        }

        public Criteria andVValueIsNotNull() {
            addCriterion("var_info_view.v_value is not null");
            return (Criteria) this;
        }

        public Criteria andVValueEqualTo(String value) {
            addCriterion("var_info_view.v_value =", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueNotEqualTo(String value) {
            addCriterion("var_info_view.v_value <>", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueGreaterThan(String value) {
            addCriterion("var_info_view.v_value >", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_value >=", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueLessThan(String value) {
            addCriterion("var_info_view.v_value <", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.v_value <=", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueLike(String value) {
            addCriterion("var_info_view.v_value like", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueNotLike(String value) {
            addCriterion("var_info_view.v_value not like", value, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueIn(List<String> values) {
            addCriterion("var_info_view.v_value in", values, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueNotIn(List<String> values) {
            addCriterion("var_info_view.v_value not in", values, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueBetween(String value1, String value2) {
            addCriterion("var_info_view.v_value between", value1, value2, "vValue");
            return (Criteria) this;
        }

        public Criteria andVValueNotBetween(String value1, String value2) {
            addCriterion("var_info_view.v_value not between", value1, value2, "vValue");
            return (Criteria) this;
        }

        public Criteria andFIdIsNull() {
            addCriterion("var_info_view.f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("var_info_view.f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("var_info_view.f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("var_info_view.f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("var_info_view.f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("var_info_view.f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("var_info_view.f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("var_info_view.f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("var_info_view.f_name is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("var_info_view.f_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("var_info_view.f_name =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("var_info_view.f_name <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("var_info_view.f_name >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.f_name >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("var_info_view.f_name <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.f_name <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("var_info_view.f_name like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("var_info_view.f_name not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("var_info_view.f_name in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("var_info_view.f_name not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("var_info_view.f_name between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("var_info_view.f_name not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("var_info_view.c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("var_info_view.c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("var_info_view.c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("var_info_view.c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("var_info_view.c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("var_info_view.c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("var_info_view.c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("var_info_view.c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("var_info_view.c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("var_info_view.c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("var_info_view.c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("var_info_view.c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("var_info_view.c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("var_info_view.c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("var_info_view.c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("var_info_view.c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("var_info_view.c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("var_info_view.c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("var_info_view.c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("var_info_view.c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("var_info_view.p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("var_info_view.p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("var_info_view.p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("var_info_view.p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("var_info_view.p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("var_info_view.p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_info_view.p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("var_info_view.p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("var_info_view.p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_info_view.p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("var_info_view.p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("var_info_view.p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("var_info_view.p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("var_info_view.p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("var_info_view.p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_info_view.p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("var_info_view.p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("var_info_view.p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("var_info_view.p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("var_info_view.p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("var_info_view.p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("var_info_view.p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("var_info_view.p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("var_info_view.p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }
    }

    /**
     */
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