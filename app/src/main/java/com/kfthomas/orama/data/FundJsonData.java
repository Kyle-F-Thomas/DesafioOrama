
package com.kfthomas.orama.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FundJsonData {

    @JsonProperty
    private Long id;

    @JsonProperty("initial_date")
    private Date initialDate;

    @JsonProperty("performance_audios")
    private List<Object> performanceAudios = null;

    @JsonProperty
    private FeesData fees;

    @JsonProperty("is_simple")
    private Boolean isSimple;

    @JsonProperty("description_seo")
    private String descriptionSeo;

    @JsonProperty
    private OperabilityData operability;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("opening_date")
    private Date openingDate;

    @JsonProperty("is_closed")
    private Boolean isClosed;

    @JsonProperty("simple_name")
    private String simpleName;

    @JsonProperty("target_fund")
    private Object targetFund;

    @JsonProperty
    private List<DocumentData> documents = null;

    @JsonProperty
    private SpecificationData specification;

    @JsonProperty("quota_date")
    private Date quotaDate;

    @JsonProperty("tax_classification")
    private String taxClassification;

    @JsonProperty
    private String cnpj;

    @JsonProperty
    private DescriptionData description;

    @JsonProperty("performance_videos")
    private List<PerformanceVideoData> performanceVideos = null;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty
    private BenchmarkData benchmark;

    @JsonProperty("orama_standard")
    private Boolean oramaStandard;

    @JsonProperty
    private String slug;

    @JsonProperty("fund_situation")
    private FundSituationData fundSituation;

    @JsonProperty("volatility_12m")
    private String volatility12m;

    @JsonProperty("strategy_video")
    private StrategyVideoData strategyVideo;

    @JsonProperty("insurance_company_code")
    private Object insuranceCompanyCode;

    @JsonProperty
    private ProfitabilitiesData profitabilities;

    @JsonProperty("closed_to_capture_explanation")
    private String closedToCaptureExplanation;

    @JsonProperty("closing_date")
    private Date closingDate;

    @JsonProperty("show_detailed_review")
    private Boolean showDetailedReview;

    @JsonProperty("net_patrimony_12m")
    private String netPatrimony12m;

    @JsonProperty("is_closed_to_capture")
    private Boolean isClosedToCapture;

    @JsonProperty("fund_manager")
    private FundManagerData fundManager;

    @JsonProperty("esg_seal")
    private Boolean esgSeal;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public List<Object> getPerformanceAudios() {
        return performanceAudios;
    }

    public void setPerformanceAudios(List<Object> performanceAudios) {
        this.performanceAudios = performanceAudios;
    }

    public FeesData getFees() {
        return fees;
    }

    public void setFees(FeesData fees) {
        this.fees = fees;
    }

    public Boolean getIsSimple() {
        return isSimple;
    }

    public void setIsSimple(Boolean isSimple) {
        this.isSimple = isSimple;
    }

    public String getDescriptionSeo() {
        return descriptionSeo;
    }

    public void setDescriptionSeo(String descriptionSeo) {
        this.descriptionSeo = descriptionSeo;
    }

    public OperabilityData getOperability() {
        return operability;
    }

    public void setOperability(OperabilityData operability) {
        this.operability = operability;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public Object getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(Object targetFund) {
        this.targetFund = targetFund;
    }

    public List<DocumentData> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentData> documents) {
        this.documents = documents;
    }

    public SpecificationData getSpecification() {
        return specification;
    }

    public void setSpecification(SpecificationData specification) {
        this.specification = specification;
    }

    public Date getQuotaDate() {
        return quotaDate;
    }

    public void setQuotaDate(Date quotaDate) {
        this.quotaDate = quotaDate;
    }

    public String getTaxClassification() {
        return taxClassification;
    }

    public void setTaxClassification(String taxClassification) {
        this.taxClassification = taxClassification;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public DescriptionData getDescription() {
        return description;
    }

    public void setDescription(DescriptionData description) {
        this.description = description;
    }

    public List<PerformanceVideoData> getPerformanceVideos() {
        return performanceVideos;
    }

    public void setPerformanceVideos(List<PerformanceVideoData> performanceVideos) {
        this.performanceVideos = performanceVideos;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public BenchmarkData getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(BenchmarkData benchmark) {
        this.benchmark = benchmark;
    }

    public Boolean getOramaStandard() {
        return oramaStandard;
    }

    public void setOramaStandard(Boolean oramaStandard) {
        this.oramaStandard = oramaStandard;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public FundSituationData getFundSituation() {
        return fundSituation;
    }

    public void setFundSituation(FundSituationData fundSituation) {
        this.fundSituation = fundSituation;
    }

    public String getVolatility12m() {
        return volatility12m;
    }

    public void setVolatility12m(String volatility12m) {
        this.volatility12m = volatility12m;
    }

    public StrategyVideoData getStrategyVideo() {
        return strategyVideo;
    }

    public void setStrategyVideo(StrategyVideoData strategyVideo) {
        this.strategyVideo = strategyVideo;
    }

    public Object getInsuranceCompanyCode() {
        return insuranceCompanyCode;
    }

    public void setInsuranceCompanyCode(Object insuranceCompanyCode) {
        this.insuranceCompanyCode = insuranceCompanyCode;
    }

    public ProfitabilitiesData getProfitabilities() {
        return profitabilities;
    }

    public void setProfitabilities(ProfitabilitiesData profitabilities) {
        this.profitabilities = profitabilities;
    }

    public String getClosedToCaptureExplanation() {
        return closedToCaptureExplanation;
    }

    public void setClosedToCaptureExplanation(String closedToCaptureExplanation) {
        this.closedToCaptureExplanation = closedToCaptureExplanation;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Boolean getShowDetailedReview() {
        return showDetailedReview;
    }

    public void setShowDetailedReview(Boolean showDetailedReview) {
        this.showDetailedReview = showDetailedReview;
    }

    public String getNetPatrimony12m() {
        return netPatrimony12m;
    }

    public void setNetPatrimony12m(String netPatrimony12m) {
        this.netPatrimony12m = netPatrimony12m;
    }

    public Boolean getIsClosedToCapture() {
        return isClosedToCapture;
    }

    public void setIsClosedToCapture(Boolean isClosedToCapture) {
        this.isClosedToCapture = isClosedToCapture;
    }

    public FundManagerData getFundManager() {
        return fundManager;
    }

    public void setFundManager(FundManagerData fundManager) {
        this.fundManager = fundManager;
    }

    public Boolean getEsgSeal() {
        return esgSeal;
    }

    public void setEsgSeal(Boolean esgSeal) {
        this.esgSeal = esgSeal;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
