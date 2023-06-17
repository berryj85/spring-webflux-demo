package berryj85.demo.dataservice.module.response

import java.math.BigDecimal

data class UserProfile(
    val username: String,
    val creditBalance: BigDecimal? = null,
    val couponBalance: Int? = null,
    val coinBalance: BigDecimal? = null
)