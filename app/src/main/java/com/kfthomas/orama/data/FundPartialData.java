
package com.kfthomas.orama.data;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@Entity(tableName = "Funds")
public final class FundPartialData {

    @PrimaryKey(autoGenerate = true)
    private Long uid;

    @ColumnInfo
    private Long id;

    @ColumnInfo(name = "initial_date")
    private Date initialDate;

    @ColumnInfo(name = "performance_audios")
    private List<Object> performanceAudios = null;

    @Embedded(prefix = "fees__")
    private FeesData fees;

    @ColumnInfo(name = "is_simple")
    private Boolean isSimple;

    @ColumnInfo(name = "description_seo")
    private String descriptionSeo;

    @Embedded(prefix = "operability__")
    private OperabilityData operability;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "opening_date")
    private Date openingDate;

    @ColumnInfo(name = "is_closed")
    private Boolean isClosed;

    @ColumnInfo(name = "simple_name")
    private String simpleName;

    @ColumnInfo(name = "target_fund")
    private Object targetFund;

    @Embedded(prefix = "specification__")
    private SpecificationData specification;

    @ColumnInfo(name = "quota_date")
    private Date quotaDate;

    @ColumnInfo(name = "tax_classification")
    private String taxClassification;

    @ColumnInfo
    private String cnpj;

    @Embedded(prefix = "description__")
    private DescriptionData description;

    @ColumnInfo(name = "is_active")
    private Boolean isActive;

    @Embedded(prefix = "benchmark__")
    private BenchmarkData benchmark;

    @ColumnInfo(name = "orama_standard")
    private Boolean oramaStandard;

    @ColumnInfo
    private String slug;

    @Embedded(prefix = "fund_situation__")
    private FundSituationData fundSituation;

    @ColumnInfo(name = "volatility_12m")
    private String volatility12m;

    @Embedded(prefix = "strategy_video__")
    private StrategyVideoData strategyVideo;

    @ColumnInfo(name = "insurance_company_code")
    private Object insuranceCompanyCode;

    @Embedded(prefix = "profitabilities__")
    private ProfitabilitiesData profitabilities;

    @ColumnInfo(name = "closed_to_capture_explanation")
    private String closedToCaptureExplanation;

    @ColumnInfo(name = "closing_date")
    private Date closingDate;

    @ColumnInfo(name = "show_detailed_review")
    private Boolean showDetailedReview;

    @ColumnInfo(name = "net_patrimony_12m")
    private String netPatrimony12m;

    @ColumnInfo(name = "is_closed_to_capture")
    private Boolean isClosedToCapture;

    @Embedded(prefix = "fund_manager__")
    private FundManagerData fundManager;

    @ColumnInfo(name = "esg_seal")
    private Boolean esgSeal;

    public Long getUid(){
        return uid;
    }

    public void setUid(Long uid){
        this.uid = uid;
    }

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
}
