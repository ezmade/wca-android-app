package com.example.wca

import android.graphics.BitmapFactory
import com.google.gson.Gson
import java.net.URL


data class JSON(
    val person: Person = Person(),
    val competition_count: Int = 0,
    val medals: Medals = Medals(),
    val records: Records = Records()
)

data class Person(
    val wca_id: String = "",
    val name: String = "",
    val url: String = "",
    val avatar: Avatar = Avatar()
)

data class Records(
    val national: Int = 0,
    val continental: Int = 0,
    val world: Int = 0,
    val total: Int = 0
)

data class Medals(
    val gold: Int = 0,
    val silver: Int = 0,
    val bronze: Int = 0,
    val total: Int = 0
)

data class Avatar(
    val url: String = "",
    val thumb_url: String = ""
)

fun getJSON(): Array<String> {

    val string: Array<String> = arrayOf(
  """{
    "person": {
      "wca_id": "1982BORS01",
      "name": "Jozsef Borsos",
      "url": "https://www.worldcubeassociation.org/persons/1982BORS01",
      "gender": "m",
      "country_iso2": "RS",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 3002,
          "world_rank": 83522,
          "continent_rank": 19690,
          "country_rank": 106
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982BRIN01",
      "name": "Roland Brinkmann",
      "url": "https://www.worldcubeassociation.org/persons/1982BRIN01",
      "gender": "m",
      "country_iso2": "DE",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 3059,
          "world_rank": 84864,
          "continent_rank": 20015,
          "country_rank": 1362
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982CHIL01",
      "name": "Julian Chilvers",
      "url": "https://www.worldcubeassociation.org/persons/1982CHIL01",
      "gender": "m",
      "country_iso2": "GB",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 2595,
          "world_rank": 72518,
          "continent_rank": 17121,
          "country_rank": 983
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982FRID01",
      "name": "Jessica Fridrich",
      "url": "https://www.worldcubeassociation.org/persons/1982FRID01",
      "gender": "f",
      "country_iso2": "US",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 4,
    "personal_records": {
      "333": {
        "single": {
          "best": 1712,
          "world_rank": 39396,
          "continent_rank": 9211,
          "country_rank": 6651
        },
        "average": {
          "best": 2048,
          "world_rank": 39021,
          "continent_rank": 9117,
          "country_rank": 6582
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 1,
      "bronze": 0,
      "total": 1
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982GALR01",
      "name": "Manuel Galrinho",
      "url": "https://www.worldcubeassociation.org/persons/1982GALR01",
      "gender": "m",
      "country_iso2": "PT",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 3711,
          "world_rank": 98655,
          "continent_rank": 23280,
          "country_rank": 139
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982JEAN01",
      "name": "Jerome Jean-Charles",
      "url": "https://www.worldcubeassociation.org/persons/1982JEAN01",
      "gender": "m",
      "country_iso2": "FR",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 2506,
          "world_rank": 69841,
          "continent_rank": 16514,
          "country_rank": 1032
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982LABA01",
      "name": "Zoltán Lábas",
      "url": "https://www.worldcubeassociation.org/persons/1982LABA01",
      "gender": "m",
      "country_iso2": "HU",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 2449,
          "world_rank": 68090,
          "continent_rank": 16126,
          "country_rank": 491
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 1,
      "total": 1
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "1982LAET01",
      "name": "Luc Van Laethem",
      "url": "https://www.worldcubeassociation.org/persons/1982LAET01",
      "gender": "m",
      "country_iso2": "BE",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 1,
    "personal_records": {
      "333": {
        "single": {
          "best": 2973,
          "world_rank": 82826,
          "continent_rank": 19527,
          "country_rank": 279
        }
      }
    },
    "medals": {
      "gold": 0,
      "silver": 0,
      "bronze": 0,
      "total": 0
    },
    "records": {
      "national": 1,
      "continental": 0,
      "world": 0,
      "total": 1
    }
  }""",
  """{
    "person": {
      "wca_id": "2014BOYK01",
      "name": "Anton Boyko",
      "url": "https://www.worldcubeassociation.org/persons/2014BOYK01",
      "gender": "m",
      "country_iso2": "RU",
      "delegate_status": null,
      "teams": [

        ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/uploads/user/avatar/2014BOYK01/1501332793.jpeg",
        "thumb_url": "https://www.worldcubeassociation.org/uploads/user/avatar/2014BOYK01/1501332793_thumb.jpeg",
        "is_default": false
      }
    },
    "competition_count": 5,
    "personal_records": {
      "222": {
        "single": {
          "best": 488,
          "world_rank": 30736,
          "continent_rank": 8513,
          "country_rank": 1357
        },
        "average": {
          "best": 673,
          "world_rank": 28372,
          "continent_rank": 7719,
          "country_rank": 1153
        }
      },
      "333": {
        "single": {
          "best": 1846,
          "world_rank": 45356,
          "continent_rank": 10681,
          "country_rank": 1698
      },
      "average": {
        "best": 2109,
        "world_rank": 41285,
        "continent_rank": 9700,
        "country_rank": 1503
      }
    },
    "333fm": {
      "single": {
        "best": 53,
        "world_rank": 5549,
        "continent_rank": 2217,
        "country_rank": 290
      }
    },
    "333oh": {
      "single": {
        "best": 3675,
        "world_rank": 22639,
        "continent_rank": 5684,
        "country_rank": 937
      },
      "average": {
        "best": 4354,
        "world_rank": 21086,
        "continent_rank": 5246,
        "country_rank": 883
      }
    },
    "444": {
      "single": {
        "best": 8552,
        "world_rank": 24629,
        "continent_rank": 6593,
        "country_rank": 969
      },
      "average": {
        "best": 10649,
        "world_rank": 23564,
        "continent_rank": 6294,
        "country_rank": 934
      }
    },
    "555": {
      "single": {
        "best": 21810,
        "world_rank": 17482,
        "continent_rank": 5493,
        "country_rank": 710
      },
      "average": {
        "best": 26428,
        "world_rank": 13242,
        "continent_rank": 3792,
        "country_rank": 514
      }
    },
    "clock": {
      "single": {
        "best": 3490,
        "world_rank": 6219,
        "continent_rank": 2227,
        "country_rank": 437
      },
      "average": {
        "best": 4178,
        "world_rank": 5090,
        "continent_rank": 1722,
        "country_rank": 348
      }
    },
    "minx": {
      "single": {
        "best": 19645,
        "world_rank": 11296,
        "continent_rank": 3693,
        "country_rank": 603
      },
      "average": {
        "best": 22016,
        "world_rank": 8606,
        "continent_rank": 2567,
        "country_rank": 446
      }
    },
    "pyram": {
      "single": {
        "best": 686,
        "world_rank": 14085,
        "continent_rank": 4564,
        "country_rank": 801
      },
      "average": {
        "best": 918,
        "world_rank": 10530,
        "continent_rank": 3380,
        "country_rank": 601
      }
    },
    "skewb": {
      "single": {
        "best": 771,
        "world_rank": 12026,
        "continent_rank": 3772,
        "country_rank": 584
      },
      "average": {
        "best": 1371,
        "world_rank": 15617,
        "continent_rank": 4738,
        "country_rank": 765
      }
    }
  },
  "medals": {
    "gold": 0,
    "silver": 1,
    "bronze": 2,
    "total": 3
  },
  "records": {
    "national": 0,
    "continental": 0,
    "world": 0,
    "total": 0
  }
  }""",
  """{
    "person": {
      "wca_id": "1982PETR01",
      "name": "Lars Petrus",
      "url": "https://www.worldcubeassociation.org/persons/1982PETR01",
      "gender": "m",
      "country_iso2": "SE",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/uploads/user/avatar/1982PETR01/1489600485.jpg",
        "thumb_url": "https://www.worldcubeassociation.org/uploads/user/avatar/1982PETR01/1489600485_thumb.jpg",
        "is_default": false
      }
    },
    "competition_count": 31,
    "personal_records": {
      "333": {
        "single": {
          "best": 1664,
          "world_rank": 37247,
          "continent_rank": 8835,
          "country_rank": 295
        },
        "average": {
          "best": 2048,
          "world_rank": 39021,
          "continent_rank": 9191,
          "country_rank": 315
        }
      },
      "333fm": {
        "single": {
          "best": 31,
          "world_rank": 936,
          "continent_rank": 435,
          "country_rank": 18
        }
      },
      "333oh": {
        "single": {
          "best": 2793,
          "world_rank": 15059,
          "continent_rank": 3733,
          "country_rank": 132
        },
        "average": {
          "best": 3490,
          "world_rank": 15413,
          "continent_rank": 3770,
          "country_rank": 140
        }
      }
    },
    "medals": {
      "gold": 3,
      "silver": 4,
      "bronze": 1,
      "total": 8
    },
    "records": {
      "national": 3,
      "continental": 7,
      "world": 0,
      "total": 10
    }
  }""",
  """{
    "person": {
      "wca_id": "1982RAZO01",
      "name": "Guus Razoux Schultz",
      "url": "https://www.worldcubeassociation.org/persons/1982RAZO01",
      "gender": "m",
      "country_iso2": "NL",
      "delegate_status": null,
      "teams": [

      ],
      "avatar": {
        "url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "thumb_url": "https://www.worldcubeassociation.org/assets/missing_avatar_thumb-f0ea801c804765a22892b57636af829edbef25260a65d90aaffbd7873bde74fc.png",
        "is_default": true
      }
    },
    "competition_count": 42,
    "personal_records": {
      "222": {
        "single": {
          "best": 646,
          "world_rank": 47095,
          "continent_rank": 12686,
          "country_rank": 394
        },
        "average": {
          "best": 926,
          "world_rank": 48234,
          "continent_rank": 12889,
          "country_rank": 388
        }
      },
      "333": {
        "single": {
          "best": 1558,
          "world_rank": 32321,
          "continent_rank": 7738,
          "country_rank": 253
        },
        "average": {
          "best": 1786,
          "world_rank": 28922,
          "continent_rank": 6864,
          "country_rank": 222
        }
      },
      "333fm": {
        "single": {
          "best": 25,
          "world_rank": 197,
          "continent_rank": 96,
          "country_rank": 3
        },
        "average": {
          "best": 2867,
          "world_rank": 132,
          "continent_rank": 52,
          "country_rank": 3
        }
      },
      "333oh": {
        "single": {
          "best": 5548,
          "world_rank": 30614,
          "continent_rank": 7973,
          "country_rank": 227
        },
        "average": {
          "best": 7458,
          "world_rank": 28068,
          "continent_rank": 7191,
          "country_rank": 205
        }
      },
      "444": {
        "single": {
          "best": 11741,
          "world_rank": 32946,
          "continent_rank": 9217,
          "country_rank": 312
        },
        "average": {
          "best": 15169,
          "world_rank": 26683,
          "continent_rank": 7153,
          "country_rank": 246
        }
      }
    },
    "medals": {
      "gold": 7,
      "silver": 7,
      "bronze": 1,
      "total": 15
    },
    "records": {
      "national": 3,
      "continental": 1,
      "world": 1,
      "total": 5
    }
  }""")
    println()
    return string
}