package com.venkat9731.mutualfunds.entity;

import com.venkat9731.mutualfunds.type.SchemeCategory;
import com.venkat9731.mutualfunds.type.SchemeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mutual_fund_schemes")
@Builder
@Getter
public class MutualFundScheme {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "scheme_code", nullable = false)
    private Integer schemeCode;

    @Column(name = "isin", nullable = false)
    private String isin;

    @Column(name = "scheme_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SchemeType schemeType;

    @Column(name = "scheme_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private SchemeCategory schemeCategory;

    @Column(name = "scheme_name", nullable = false, length = 1023)
    private String schemeName;



    @Column(name = "fund_house", nullable = false)
    private String fundHouse;



}
