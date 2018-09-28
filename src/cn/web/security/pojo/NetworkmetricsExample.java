package cn.web.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class NetworkmetricsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public NetworkmetricsExample() {
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

        public Criteria andVertexnumIsNull() {
            addCriterion("vertexNum is null");
            return (Criteria) this;
        }

        public Criteria andVertexnumIsNotNull() {
            addCriterion("vertexNum is not null");
            return (Criteria) this;
        }

        public Criteria andVertexnumEqualTo(Integer value) {
            addCriterion("vertexNum =", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumNotEqualTo(Integer value) {
            addCriterion("vertexNum <>", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumGreaterThan(Integer value) {
            addCriterion("vertexNum >", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("vertexNum >=", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumLessThan(Integer value) {
            addCriterion("vertexNum <", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumLessThanOrEqualTo(Integer value) {
            addCriterion("vertexNum <=", value, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumIn(List<Integer> values) {
            addCriterion("vertexNum in", values, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumNotIn(List<Integer> values) {
            addCriterion("vertexNum not in", values, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumBetween(Integer value1, Integer value2) {
            addCriterion("vertexNum between", value1, value2, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andVertexnumNotBetween(Integer value1, Integer value2) {
            addCriterion("vertexNum not between", value1, value2, "vertexnum");
            return (Criteria) this;
        }

        public Criteria andEdgenumIsNull() {
            addCriterion("edgeNum is null");
            return (Criteria) this;
        }

        public Criteria andEdgenumIsNotNull() {
            addCriterion("edgeNum is not null");
            return (Criteria) this;
        }

        public Criteria andEdgenumEqualTo(Integer value) {
            addCriterion("edgeNum =", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumNotEqualTo(Integer value) {
            addCriterion("edgeNum <>", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumGreaterThan(Integer value) {
            addCriterion("edgeNum >", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("edgeNum >=", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumLessThan(Integer value) {
            addCriterion("edgeNum <", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumLessThanOrEqualTo(Integer value) {
            addCriterion("edgeNum <=", value, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumIn(List<Integer> values) {
            addCriterion("edgeNum in", values, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumNotIn(List<Integer> values) {
            addCriterion("edgeNum not in", values, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumBetween(Integer value1, Integer value2) {
            addCriterion("edgeNum between", value1, value2, "edgenum");
            return (Criteria) this;
        }

        public Criteria andEdgenumNotBetween(Integer value1, Integer value2) {
            addCriterion("edgeNum not between", value1, value2, "edgenum");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterIsNull() {
            addCriterion("networkDiameter is null");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterIsNotNull() {
            addCriterion("networkDiameter is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterEqualTo(Integer value) {
            addCriterion("networkDiameter =", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterNotEqualTo(Integer value) {
            addCriterion("networkDiameter <>", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterGreaterThan(Integer value) {
            addCriterion("networkDiameter >", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterGreaterThanOrEqualTo(Integer value) {
            addCriterion("networkDiameter >=", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterLessThan(Integer value) {
            addCriterion("networkDiameter <", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterLessThanOrEqualTo(Integer value) {
            addCriterion("networkDiameter <=", value, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterIn(List<Integer> values) {
            addCriterion("networkDiameter in", values, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterNotIn(List<Integer> values) {
            addCriterion("networkDiameter not in", values, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterBetween(Integer value1, Integer value2) {
            addCriterion("networkDiameter between", value1, value2, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkdiameterNotBetween(Integer value1, Integer value2) {
            addCriterion("networkDiameter not between", value1, value2, "networkdiameter");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessIsNull() {
            addCriterion("networkCoreness is null");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessIsNotNull() {
            addCriterion("networkCoreness is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessEqualTo(Integer value) {
            addCriterion("networkCoreness =", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessNotEqualTo(Integer value) {
            addCriterion("networkCoreness <>", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessGreaterThan(Integer value) {
            addCriterion("networkCoreness >", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessGreaterThanOrEqualTo(Integer value) {
            addCriterion("networkCoreness >=", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessLessThan(Integer value) {
            addCriterion("networkCoreness <", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessLessThanOrEqualTo(Integer value) {
            addCriterion("networkCoreness <=", value, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessIn(List<Integer> values) {
            addCriterion("networkCoreness in", values, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessNotIn(List<Integer> values) {
            addCriterion("networkCoreness not in", values, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessBetween(Integer value1, Integer value2) {
            addCriterion("networkCoreness between", value1, value2, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNetworkcorenessNotBetween(Integer value1, Integer value2) {
            addCriterion("networkCoreness not between", value1, value2, "networkcoreness");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeIsNull() {
            addCriterion("nodeAverageDegree is null");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeIsNotNull() {
            addCriterion("nodeAverageDegree is not null");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeEqualTo(Double value) {
            addCriterion("nodeAverageDegree =", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeNotEqualTo(Double value) {
            addCriterion("nodeAverageDegree <>", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeGreaterThan(Double value) {
            addCriterion("nodeAverageDegree >", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeGreaterThanOrEqualTo(Double value) {
            addCriterion("nodeAverageDegree >=", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeLessThan(Double value) {
            addCriterion("nodeAverageDegree <", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeLessThanOrEqualTo(Double value) {
            addCriterion("nodeAverageDegree <=", value, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeIn(List<Double> values) {
            addCriterion("nodeAverageDegree in", values, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeNotIn(List<Double> values) {
            addCriterion("nodeAverageDegree not in", values, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeBetween(Double value1, Double value2) {
            addCriterion("nodeAverageDegree between", value1, value2, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andNodeaveragedegreeNotBetween(Double value1, Double value2) {
            addCriterion("nodeAverageDegree not between", value1, value2, "nodeaveragedegree");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthIsNull() {
            addCriterion("averageShortestPathLength is null");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthIsNotNull() {
            addCriterion("averageShortestPathLength is not null");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthEqualTo(Double value) {
            addCriterion("averageShortestPathLength =", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthNotEqualTo(Double value) {
            addCriterion("averageShortestPathLength <>", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthGreaterThan(Double value) {
            addCriterion("averageShortestPathLength >", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthGreaterThanOrEqualTo(Double value) {
            addCriterion("averageShortestPathLength >=", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthLessThan(Double value) {
            addCriterion("averageShortestPathLength <", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthLessThanOrEqualTo(Double value) {
            addCriterion("averageShortestPathLength <=", value, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthIn(List<Double> values) {
            addCriterion("averageShortestPathLength in", values, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthNotIn(List<Double> values) {
            addCriterion("averageShortestPathLength not in", values, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthBetween(Double value1, Double value2) {
            addCriterion("averageShortestPathLength between", value1, value2, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andAverageshortestpathlengthNotBetween(Double value1, Double value2) {
            addCriterion("averageShortestPathLength not between", value1, value2, "averageshortestpathlength");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyIsNull() {
            addCriterion("networkEfficiency is null");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyIsNotNull() {
            addCriterion("networkEfficiency is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyEqualTo(Double value) {
            addCriterion("networkEfficiency =", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyNotEqualTo(Double value) {
            addCriterion("networkEfficiency <>", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyGreaterThan(Double value) {
            addCriterion("networkEfficiency >", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyGreaterThanOrEqualTo(Double value) {
            addCriterion("networkEfficiency >=", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyLessThan(Double value) {
            addCriterion("networkEfficiency <", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyLessThanOrEqualTo(Double value) {
            addCriterion("networkEfficiency <=", value, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyIn(List<Double> values) {
            addCriterion("networkEfficiency in", values, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyNotIn(List<Double> values) {
            addCriterion("networkEfficiency not in", values, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyBetween(Double value1, Double value2) {
            addCriterion("networkEfficiency between", value1, value2, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkefficiencyNotBetween(Double value1, Double value2) {
            addCriterion("networkEfficiency not between", value1, value2, "networkefficiency");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientIsNull() {
            addCriterion("networkClusteringCoefficient is null");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientIsNotNull() {
            addCriterion("networkClusteringCoefficient is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientEqualTo(Double value) {
            addCriterion("networkClusteringCoefficient =", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientNotEqualTo(Double value) {
            addCriterion("networkClusteringCoefficient <>", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientGreaterThan(Double value) {
            addCriterion("networkClusteringCoefficient >", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientGreaterThanOrEqualTo(Double value) {
            addCriterion("networkClusteringCoefficient >=", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientLessThan(Double value) {
            addCriterion("networkClusteringCoefficient <", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientLessThanOrEqualTo(Double value) {
            addCriterion("networkClusteringCoefficient <=", value, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientIn(List<Double> values) {
            addCriterion("networkClusteringCoefficient in", values, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientNotIn(List<Double> values) {
            addCriterion("networkClusteringCoefficient not in", values, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientBetween(Double value1, Double value2) {
            addCriterion("networkClusteringCoefficient between", value1, value2, "networkclusteringcoefficient");
            return (Criteria) this;
        }

        public Criteria andNetworkclusteringcoefficientNotBetween(Double value1, Double value2) {
            addCriterion("networkClusteringCoefficient not between", value1, value2, "networkclusteringcoefficient");
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