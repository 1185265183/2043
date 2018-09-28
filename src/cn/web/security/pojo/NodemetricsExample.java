package cn.web.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class NodemetricsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public NodemetricsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNull() {
            addCriterion("`degree` is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("`degree` is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(Integer value) {
            addCriterion("`degree` =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(Integer value) {
            addCriterion("`degree` <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(Integer value) {
            addCriterion("`degree` >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`degree` >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(Integer value) {
            addCriterion("`degree` <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("`degree` <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<Integer> values) {
            addCriterion("`degree` in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<Integer> values) {
            addCriterion("`degree` not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(Integer value1, Integer value2) {
            addCriterion("`degree` between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("`degree` not between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andIndegreeIsNull() {
            addCriterion("inDegree is null");
            return (Criteria) this;
        }

        public Criteria andIndegreeIsNotNull() {
            addCriterion("inDegree is not null");
            return (Criteria) this;
        }

        public Criteria andIndegreeEqualTo(Integer value) {
            addCriterion("inDegree =", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeNotEqualTo(Integer value) {
            addCriterion("inDegree <>", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeGreaterThan(Integer value) {
            addCriterion("inDegree >", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("inDegree >=", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeLessThan(Integer value) {
            addCriterion("inDegree <", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeLessThanOrEqualTo(Integer value) {
            addCriterion("inDegree <=", value, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeIn(List<Integer> values) {
            addCriterion("inDegree in", values, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeNotIn(List<Integer> values) {
            addCriterion("inDegree not in", values, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeBetween(Integer value1, Integer value2) {
            addCriterion("inDegree between", value1, value2, "indegree");
            return (Criteria) this;
        }

        public Criteria andIndegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("inDegree not between", value1, value2, "indegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeIsNull() {
            addCriterion("outDegree is null");
            return (Criteria) this;
        }

        public Criteria andOutdegreeIsNotNull() {
            addCriterion("outDegree is not null");
            return (Criteria) this;
        }

        public Criteria andOutdegreeEqualTo(Integer value) {
            addCriterion("outDegree =", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeNotEqualTo(Integer value) {
            addCriterion("outDegree <>", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeGreaterThan(Integer value) {
            addCriterion("outDegree >", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("outDegree >=", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeLessThan(Integer value) {
            addCriterion("outDegree <", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeLessThanOrEqualTo(Integer value) {
            addCriterion("outDegree <=", value, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeIn(List<Integer> values) {
            addCriterion("outDegree in", values, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeNotIn(List<Integer> values) {
            addCriterion("outDegree not in", values, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeBetween(Integer value1, Integer value2) {
            addCriterion("outDegree between", value1, value2, "outdegree");
            return (Criteria) this;
        }

        public Criteria andOutdegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("outDegree not between", value1, value2, "outdegree");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionIsNull() {
            addCriterion("nodeInfluenceRegion is null");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionIsNotNull() {
            addCriterion("nodeInfluenceRegion is not null");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionEqualTo(Double value) {
            addCriterion("nodeInfluenceRegion =", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionNotEqualTo(Double value) {
            addCriterion("nodeInfluenceRegion <>", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionGreaterThan(Double value) {
            addCriterion("nodeInfluenceRegion >", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeInfluenceRegion >=", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionLessThan(Double value) {
            addCriterion("nodeInfluenceRegion <", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionLessThanOrEqualTo(Double value) {
            addCriterion("nodeInfluenceRegion <=", value, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionIn(List<Double> values) {
            addCriterion("nodeInfluenceRegion in", values, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionNotIn(List<Double> values) {
            addCriterion("nodeInfluenceRegion not in", values, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionBetween(Double value1, Double value2) {
            addCriterion("nodeInfluenceRegion between", value1, value2, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodeinfluenceregionNotBetween(Double value1, Double value2) {
            addCriterion("nodeInfluenceRegion not between", value1, value2, "nodeinfluenceregion");
            return (Criteria) this;
        }

        public Criteria andNodemncIsNull() {
            addCriterion("nodeMNC is null");
            return (Criteria) this;
        }

        public Criteria andNodemncIsNotNull() {
            addCriterion("nodeMNC is not null");
            return (Criteria) this;
        }

        public Criteria andNodemncEqualTo(Double value) {
            addCriterion("nodeMNC =", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncNotEqualTo(Double value) {
            addCriterion("nodeMNC <>", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncGreaterThan(Double value) {
            addCriterion("nodeMNC >", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeMNC >=", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncLessThan(Double value) {
            addCriterion("nodeMNC <", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncLessThanOrEqualTo(Double value) {
            addCriterion("nodeMNC <=", value, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncIn(List<Double> values) {
            addCriterion("nodeMNC in", values, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncNotIn(List<Double> values) {
            addCriterion("nodeMNC not in", values, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncBetween(Double value1, Double value2) {
            addCriterion("nodeMNC between", value1, value2, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodemncNotBetween(Double value1, Double value2) {
            addCriterion("nodeMNC not between", value1, value2, "nodemnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncIsNull() {
            addCriterion("nodeDMNC is null");
            return (Criteria) this;
        }

        public Criteria andNodedmncIsNotNull() {
            addCriterion("nodeDMNC is not null");
            return (Criteria) this;
        }

        public Criteria andNodedmncEqualTo(Double value) {
            addCriterion("nodeDMNC =", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncNotEqualTo(Double value) {
            addCriterion("nodeDMNC <>", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncGreaterThan(Double value) {
            addCriterion("nodeDMNC >", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeDMNC >=", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncLessThan(Double value) {
            addCriterion("nodeDMNC <", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncLessThanOrEqualTo(Double value) {
            addCriterion("nodeDMNC <=", value, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncIn(List<Double> values) {
            addCriterion("nodeDMNC in", values, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncNotIn(List<Double> values) {
            addCriterion("nodeDMNC not in", values, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncBetween(Double value1, Double value2) {
            addCriterion("nodeDMNC between", value1, value2, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andNodedmncNotBetween(Double value1, Double value2) {
            addCriterion("nodeDMNC not between", value1, value2, "nodedmnc");
            return (Criteria) this;
        }

        public Criteria andProximityIsNull() {
            addCriterion("proximity is null");
            return (Criteria) this;
        }

        public Criteria andProximityIsNotNull() {
            addCriterion("proximity is not null");
            return (Criteria) this;
        }

        public Criteria andProximityEqualTo(Double value) {
            addCriterion("proximity =", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityNotEqualTo(Double value) {
            addCriterion("proximity <>", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityGreaterThan(Double value) {
            addCriterion("proximity >", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityGreaterThanOrEqualTo(Double value) {
            addCriterion("proximity >=", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityLessThan(Double value) {
            addCriterion("proximity <", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityLessThanOrEqualTo(Double value) {
            addCriterion("proximity <=", value, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityIn(List<Double> values) {
            addCriterion("proximity in", values, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityNotIn(List<Double> values) {
            addCriterion("proximity not in", values, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityBetween(Double value1, Double value2) {
            addCriterion("proximity between", value1, value2, "proximity");
            return (Criteria) this;
        }

        public Criteria andProximityNotBetween(Double value1, Double value2) {
            addCriterion("proximity not between", value1, value2, "proximity");
            return (Criteria) this;
        }

        public Criteria andNodeccIsNull() {
            addCriterion("nodeCC is null");
            return (Criteria) this;
        }

        public Criteria andNodeccIsNotNull() {
            addCriterion("nodeCC is not null");
            return (Criteria) this;
        }

        public Criteria andNodeccEqualTo(Double value) {
            addCriterion("nodeCC =", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccNotEqualTo(Double value) {
            addCriterion("nodeCC <>", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccGreaterThan(Double value) {
            addCriterion("nodeCC >", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeCC >=", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccLessThan(Double value) {
            addCriterion("nodeCC <", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccLessThanOrEqualTo(Double value) {
            addCriterion("nodeCC <=", value, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccIn(List<Double> values) {
            addCriterion("nodeCC in", values, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccNotIn(List<Double> values) {
            addCriterion("nodeCC not in", values, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccBetween(Double value1, Double value2) {
            addCriterion("nodeCC between", value1, value2, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodeccNotBetween(Double value1, Double value2) {
            addCriterion("nodeCC not between", value1, value2, "nodecc");
            return (Criteria) this;
        }

        public Criteria andNodebcIsNull() {
            addCriterion("nodeBC is null");
            return (Criteria) this;
        }

        public Criteria andNodebcIsNotNull() {
            addCriterion("nodeBC is not null");
            return (Criteria) this;
        }

        public Criteria andNodebcEqualTo(Double value) {
            addCriterion("nodeBC =", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcNotEqualTo(Double value) {
            addCriterion("nodeBC <>", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcGreaterThan(Double value) {
            addCriterion("nodeBC >", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeBC >=", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcLessThan(Double value) {
            addCriterion("nodeBC <", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcLessThanOrEqualTo(Double value) {
            addCriterion("nodeBC <=", value, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcIn(List<Double> values) {
            addCriterion("nodeBC in", values, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcNotIn(List<Double> values) {
            addCriterion("nodeBC not in", values, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcBetween(Double value1, Double value2) {
            addCriterion("nodeBC between", value1, value2, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodebcNotBetween(Double value1, Double value2) {
            addCriterion("nodeBC not between", value1, value2, "nodebc");
            return (Criteria) this;
        }

        public Criteria andNodecoreIsNull() {
            addCriterion("nodeCore is null");
            return (Criteria) this;
        }

        public Criteria andNodecoreIsNotNull() {
            addCriterion("nodeCore is not null");
            return (Criteria) this;
        }

        public Criteria andNodecoreEqualTo(Integer value) {
            addCriterion("nodeCore =", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreNotEqualTo(Integer value) {
            addCriterion("nodeCore <>", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreGreaterThan(Integer value) {
            addCriterion("nodeCore >", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodeCore >=", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreLessThan(Integer value) {
            addCriterion("nodeCore <", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreLessThanOrEqualTo(Integer value) {
            addCriterion("nodeCore <=", value, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreIn(List<Integer> values) {
            addCriterion("nodeCore in", values, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreNotIn(List<Integer> values) {
            addCriterion("nodeCore not in", values, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreBetween(Integer value1, Integer value2) {
            addCriterion("nodeCore between", value1, value2, "nodecore");
            return (Criteria) this;
        }

        public Criteria andNodecoreNotBetween(Integer value1, Integer value2) {
            addCriterion("nodeCore not between", value1, value2, "nodecore");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityIsNull() {
            addCriterion("degreeCentrality is null");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityIsNotNull() {
            addCriterion("degreeCentrality is not null");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityEqualTo(Double value) {
            addCriterion("degreeCentrality =", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityNotEqualTo(Double value) {
            addCriterion("degreeCentrality <>", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityGreaterThan(Double value) {
            addCriterion("degreeCentrality >", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityGreaterThanOrEqualTo(Double value) {
            addCriterion("degreeCentrality >=", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityLessThan(Double value) {
            addCriterion("degreeCentrality <", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityLessThanOrEqualTo(Double value) {
            addCriterion("degreeCentrality <=", value, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityIn(List<Double> values) {
            addCriterion("degreeCentrality in", values, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityNotIn(List<Double> values) {
            addCriterion("degreeCentrality not in", values, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityBetween(Double value1, Double value2) {
            addCriterion("degreeCentrality between", value1, value2, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andDegreecentralityNotBetween(Double value1, Double value2) {
            addCriterion("degreeCentrality not between", value1, value2, "degreecentrality");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectid is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("projectid =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("projectid <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("projectid >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectid >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("projectid <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("projectid <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("projectid in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("projectid not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("projectid between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectid not between", value1, value2, "projectid");
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