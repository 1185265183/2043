package cn.web.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class FunctionsInfoViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public FunctionsInfoViewExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("f_name is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("f_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("f_name =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("f_name <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("f_name >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_name >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("f_name <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("f_name <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("f_name like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("f_name not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("f_name in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("f_name not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("f_name between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("f_name not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFModifiterIsNull() {
            addCriterion("f_modifiter is null");
            return (Criteria) this;
        }

        public Criteria andFModifiterIsNotNull() {
            addCriterion("f_modifiter is not null");
            return (Criteria) this;
        }

        public Criteria andFModifiterEqualTo(String value) {
            addCriterion("f_modifiter =", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterNotEqualTo(String value) {
            addCriterion("f_modifiter <>", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterGreaterThan(String value) {
            addCriterion("f_modifiter >", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterGreaterThanOrEqualTo(String value) {
            addCriterion("f_modifiter >=", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterLessThan(String value) {
            addCriterion("f_modifiter <", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterLessThanOrEqualTo(String value) {
            addCriterion("f_modifiter <=", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterLike(String value) {
            addCriterion("f_modifiter like", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterNotLike(String value) {
            addCriterion("f_modifiter not like", value, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterIn(List<String> values) {
            addCriterion("f_modifiter in", values, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterNotIn(List<String> values) {
            addCriterion("f_modifiter not in", values, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterBetween(String value1, String value2) {
            addCriterion("f_modifiter between", value1, value2, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFModifiterNotBetween(String value1, String value2) {
            addCriterion("f_modifiter not between", value1, value2, "fModifiter");
            return (Criteria) this;
        }

        public Criteria andFReturntypeIsNull() {
            addCriterion("f_returntype is null");
            return (Criteria) this;
        }

        public Criteria andFReturntypeIsNotNull() {
            addCriterion("f_returntype is not null");
            return (Criteria) this;
        }

        public Criteria andFReturntypeEqualTo(String value) {
            addCriterion("f_returntype =", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeNotEqualTo(String value) {
            addCriterion("f_returntype <>", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeGreaterThan(String value) {
            addCriterion("f_returntype >", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_returntype >=", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeLessThan(String value) {
            addCriterion("f_returntype <", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeLessThanOrEqualTo(String value) {
            addCriterion("f_returntype <=", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeLike(String value) {
            addCriterion("f_returntype like", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeNotLike(String value) {
            addCriterion("f_returntype not like", value, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeIn(List<String> values) {
            addCriterion("f_returntype in", values, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeNotIn(List<String> values) {
            addCriterion("f_returntype not in", values, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeBetween(String value1, String value2) {
            addCriterion("f_returntype between", value1, value2, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFReturntypeNotBetween(String value1, String value2) {
            addCriterion("f_returntype not between", value1, value2, "fReturntype");
            return (Criteria) this;
        }

        public Criteria andFParameterIsNull() {
            addCriterion("f_parameter is null");
            return (Criteria) this;
        }

        public Criteria andFParameterIsNotNull() {
            addCriterion("f_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andFParameterEqualTo(String value) {
            addCriterion("f_parameter =", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterNotEqualTo(String value) {
            addCriterion("f_parameter <>", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterGreaterThan(String value) {
            addCriterion("f_parameter >", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterGreaterThanOrEqualTo(String value) {
            addCriterion("f_parameter >=", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterLessThan(String value) {
            addCriterion("f_parameter <", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterLessThanOrEqualTo(String value) {
            addCriterion("f_parameter <=", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterLike(String value) {
            addCriterion("f_parameter like", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterNotLike(String value) {
            addCriterion("f_parameter not like", value, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterIn(List<String> values) {
            addCriterion("f_parameter in", values, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterNotIn(List<String> values) {
            addCriterion("f_parameter not in", values, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterBetween(String value1, String value2) {
            addCriterion("f_parameter between", value1, value2, "fParameter");
            return (Criteria) this;
        }

        public Criteria andFParameterNotBetween(String value1, String value2) {
            addCriterion("f_parameter not between", value1, value2, "fParameter");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
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