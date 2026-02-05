//
//  ViewController.swift
//  iosApp
//
//  Created by tes 123 on 02/02/26.
//

import UIKit
import Shared

class ViewController: UIViewController {

    @IBOutlet weak var greetingLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        loadGreeting()
    }

    private func loadGreeting() {
        // Use shared Kotlin code!
        let greeting = Greeting().greet()
        greetingLabel.text = greeting
        print("Greeting from Kotlin: \(greeting)")
    }

}
