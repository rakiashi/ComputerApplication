$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/CreateComputer.feature");
formatter.feature({
  "name": "Create a computer",
  "description": "  As a user\n  I want to create one computer",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.background({
  "name": "Computer data base",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Create one Computer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer as \"ACE 2022\" name",
  "keyword": "Given "
});
formatter.match({
  "location": "AddComputerSteps.iAddAnNewComputerAsDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer has been created",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iShouldSeeComputerHasBeenCreatedUpdatedDeleted(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"ACE 2022\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer \"ACE 2022\" listed in result table",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeComputerListedInResultTable(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.background({
  "name": "Computer data base",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "To verify cancel functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iAddAnNewComputer()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I tried to create computer and i see name is required",
  "keyword": "When "
});
formatter.match({
  "location": "AddComputerSteps.iCreateComputerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I cancel computer details",
  "keyword": "When "
});
formatter.match({
  "location": "EditComputerSteps.iCancelCanceledComputerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see redirecting to computer database",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeRedirectingToComputerDatabase()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.background({
  "name": "Computer data base",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "To verify field errors while creating computer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iAddAnNewComputer()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I enter computer \"name\" as \"Dell India\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddComputerSteps.iEnterComputerWith(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I enter computer \"introduced\" as \"23MAR2019\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddComputerSteps.iEnterComputerWith(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I tried to create computer and i see date format is incorrect",
  "keyword": "When "
});
formatter.match({
  "location": "AddComputerSteps.iTriedToCreateComputerAndISeeDateFormatIsIncorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I cancel computer details",
  "keyword": "When "
});
formatter.match({
  "location": "EditComputerSteps.iCancelCanceledComputerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see redirecting to computer database",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeRedirectingToComputerDatabase()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/DeleteComputer.feature");
formatter.feature({
  "name": "Delete a computer",
  "description": "  As a user\n  I want to delete one computer",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.background({
  "name": "computer data base",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete one Computer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer as \"LENOVO 2020\" name",
  "keyword": "Given "
});
formatter.match({
  "location": "AddComputerSteps.iAddAnNewComputerAsDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"LENOVO 2020\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer \"LENOVO 2020\" details",
  "rows": [
    {
      "cells": [
        "LENOVO 2020"
      ]
    },
    {
      "cells": [
        "2020-01-02"
      ]
    },
    {
      "cells": [
        "2020-12-31"
      ]
    },
    {
      "cells": [
        "Lenovo Group"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "EditComputerSteps.iShouldBeAbleToReadThoseComputerDetails(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I delete computer details",
  "keyword": "When "
});
formatter.match({
  "location": "EditComputerSteps.iDeleteCanceledComputerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer has been deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iShouldSeeComputerHasBeenCreatedUpdatedDeleted(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"LENOVO 2020\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see nothing to display",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeNothingToDisplayMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/UpdateComputer.feature");
formatter.feature({
  "name": "Update a computer",
  "description": "  As a user\n  I want to update one computer",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.background({
  "name": "Computer data base",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Update one Computer and verify its updated or not",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer as \"MAC BOOK 2020\" name",
  "keyword": "Given "
});
formatter.match({
  "location": "AddComputerSteps.iAddAnNewComputerAsDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"MAC BOOK 2020\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer \"MAC BOOK 2020\" details",
  "rows": [
    {
      "cells": [
        "MAC BOOK 2020"
      ]
    },
    {
      "cells": [
        "2019-09-02"
      ]
    },
    {
      "cells": [
        "2019-09-30"
      ]
    },
    {
      "cells": [
        "RCA"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "EditComputerSteps.iShouldBeAbleToReadThoseComputerDetails(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I update computer name with \"MAC BOOK 2021\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditComputerSteps.iUpdateComputerNameWith(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I update computer introduced date with \"2019-10-02\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditComputerSteps.iUpdateComputerIntroducedWith(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I update computer details",
  "keyword": "When "
});
formatter.match({
  "location": "EditComputerSteps.iUpdatedCanceledComputerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer has been updated",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iShouldSeeComputerHasBeenCreatedUpdatedDeleted(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"MAC BOOK 2021\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer \"MAC BOOK 2021\" details",
  "rows": [
    {
      "cells": [
        "MAC BOOK 2021"
      ]
    },
    {
      "cells": [
        "2019-10-02"
      ]
    },
    {
      "cells": [
        "2019-09-30"
      ]
    },
    {
      "cells": [
        "RCA"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "EditComputerSteps.iShouldBeAbleToReadThoseComputerDetails(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/ViewAndSearchComputer.feature");
formatter.feature({
  "name": "View and Search one computer",
  "description": "  As a user\n  I want to view and search one computer",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.background({
  "name": "Computer database",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "View and Search one Computer from database",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I add an new computer as \"ACE 2024\" name",
  "keyword": "Given "
});
formatter.match({
  "location": "AddComputerSteps.iAddAnNewComputerAsDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I search for computer name as \"ACE 2024\"",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see computer \"ACE 2024\" listed in result table",
  "keyword": "Then "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeComputerListedInResultTable(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.background({
  "name": "Computer database",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I launch computer data base application",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iLaunchComputerDataBaseApp()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "View and Search Computer which is not in database",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I search for computer name as \"Test computer\"",
  "keyword": "Given "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSearchForComputerNameAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I see nothing to display",
  "keyword": "When "
});
formatter.match({
  "location": "ComputerDatabaseSteps.iSeeNothingToDisplayMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
});